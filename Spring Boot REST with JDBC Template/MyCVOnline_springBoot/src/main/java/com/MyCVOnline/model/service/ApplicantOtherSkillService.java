package com.MyCVOnline.model.service;

import java.util.ArrayList;
import com.MyCVOnline.model.*;

public interface ApplicantOtherSkillService {

	public void insertApplicantOtherSkill(Applicant applicant,ApplicantOtherSkill otherSkill);

	public void deleteApplicantOtherSkill(String applicantID, String skillName);

	public ApplicantOtherSkill retreiveApplicantOtherSkill(String applicantID, String skillName);

	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkillsByID(String applicantID);

	public void updateApplicantOtherSkill(ApplicantOtherSkill otherSkill);

	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkills();

}
