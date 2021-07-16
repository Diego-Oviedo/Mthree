package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantOtherSkill;

public interface ApplicantOtherSkillDAO {

	public void insertApplicantOtherSkill(Applicant applicant,ApplicantOtherSkill otherSkill);

	public void deleteApplicantOtherSkill(String applicantID, String skillName);

	public ApplicantOtherSkill retreiveApplicantOtherSkill(String applicantID, String skillName);

	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkillsByID(String applicantID);

	public void updateApplicantOtherSkill(ApplicantOtherSkill otherSkill);

	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkills();

}
