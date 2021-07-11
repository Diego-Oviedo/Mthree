package com.sg.jdbctcomplexexample.dao.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sg.jdbctcomplexexample.TestApplicationConfiguration;
import com.sg.jdbctcomplexexample.dao.EmployeeDao;
import com.sg.jdbctcomplexexample.dao.MeetingDao;
import com.sg.jdbctcomplexexample.dao.RoomDao;
import com.sg.jdbctcomplexexample.entity.Employee;
import com.sg.jdbctcomplexexample.entity.Meeting;
import com.sg.jdbctcomplexexample.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class EmployeeDaoDBTest {

	@Autowired
    RoomDao roomDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    MeetingDao meetingDao;
    
    @Before
    public void setUp() {
        List<Room> rooms = roomDao.getAllRooms();
        for (Room room : rooms) {
            roomDao.deleteRoomById(room.getId());
        }

        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }

        List<Meeting> meetings = meetingDao.getAllMeetings();
        for (Meeting meeting : meetings) {
            meetingDao.deleteMeetingById(meeting.getId());
        }
    }
    
    @Test
    public void testAddGetEmployee() {
    	//ARRANGE
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        
        //ACT
        employee = employeeDao.addEmployee(employee);
        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        
        
        //ASSERT
        assertEquals(employee, fromDao);
    }
    
    @Test
    public void testGetAllEmployees() {
    	//ARRANGE
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2 = employeeDao.addEmployee(employee2);
        
        //ACT
        List<Employee> employees = employeeDao.getAllEmployees();
        
        //ASSERT
        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee));
        assertTrue(employees.contains(employee2));
    }
    
    @Test
    public void testUpdateEmployee() {
    	//ARRANGE
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        
        assertEquals(employee, fromDao);
        
        employee.setFirstName("Another Test First");
        
        //ACT
        employeeDao.updateEmployee(employee);
        
        //ASSERT
        assertNotEquals(employee, fromDao);
        
        fromDao = employeeDao.getEmployeeById(employee.getId());
        
        assertEquals(employee, fromDao);
    }

    @Test
    public void testDeleteEmployee() {
    	//ARRANGE
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee = employeeDao.addEmployee(employee);
        
        Room room = new Room();
        room.setName("Test Room");
        room.setDescription("Test Room Description");
        room = roomDao.addRoom(room);
        
        Meeting meeting = new Meeting();
        meeting.setName("Test Meeting");
        meeting.setTime(LocalDateTime.now());
        meeting.setRoom(room);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        meeting.setAttendees(employees);
        meeting = meetingDao.addMeeting(meeting);
        
        //ACT
        employeeDao.deleteEmployeeById(employee.getId());
        
        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        
        //ASSERT
        assertNull(fromDao);
    }
    
    
}
