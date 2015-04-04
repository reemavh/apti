function submitContact() {
	var title = document.getElementById("title").value;
	var email = document.getElementById("email").value;
	var ph1 = document.getElementById("ph1").value;
	var ph2 = document.getElementById("ph2").value;
	var name = document.getElementById("name").value;
	var address = document.getElementById("address").value;
	var date = document.getElementById("date_birth").value;
	var month = document.getElementById("month_birth").value;
	var year = document.getElementById("year_birth").value;
	
	if(title=="") {
		baAlert("#aTitle");
		return;
	}
	
	if(name=="") {
		baAlert("#aName");
		return;
	}
	
	if(date=="" || month == "" || year =="" ) {
		baAlert("#aYear");
		return;
	}
	
	if(email=="") {		
		baAlert("#aEmail");
		return;
	}
	
	var pattern= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(pattern.test(email) == false) {
		baAlert("#aValidEmail");
		return;
	}

	
	if(ph1=="" && ph2=="") {
		baAlert("#aPhone");
		return;
	}	
	
	if(address=="") {
		baAlert("#aAddress");
		return;
	}
	
	if(!validateDate(date, month, year)) {
		baAlert("#aDate");
		return;
	}
		
	
	localStorage.setItem("title",title);
	localStorage.setItem("name",name);
	localStorage.setItem("email",email);
	localStorage.setItem("ph1",ph1);
	localStorage.setItem("ph2",ph2);
	localStorage.setItem("address",address);
	localStorage.setItem("date_birth", date);
	localStorage.setItem("month_birth", month);
	localStorage.setItem("year_birth", year);
	window.location.href = "a2.html";
}

function validateDate(sdate, month, syear) {
	var date = parseInt(sdate);
	var year = parseInt(syear);
	if(month=="Feb" && year % 4 != 0 && date > 28)
		return false;
	if(month=="Feb" && year % 4 == 0 && date > 29 )
		return false;
	if((month == "Apr" || month == "Jun" || month == "Sep" || month == "Nov") && date == 31 )
		return false;
	return true;		
}

function submitIX() {
	var school  = document.getElementById("school9").value;
	var board   = document.getElementById("board9").value;
	var year    = document.getElementById("year9").value;
	var overall = document.getElementById("overall9").value;
	var english = document.getElementById("english9").value;
	var hindi   = document.getElementById("hindi9").value;
	var kannada = document.getElementById("kannada9").value;
	var science = document.getElementById("science9").value;
	var math    = document.getElementById("maths9").value;
	var social  = document.getElementById("social9").value;
	var otherName1  = document.getElementById("other19n").value;
	var otherName2  = document.getElementById("other29n").value;
	var other1  = document.getElementById("other19").value;
	var other2  = document.getElementById("other29").value;
	
	if(school=="") {
		baAlert("#aSchool");
		return;
	}
	if(board=="") {
		baAlert("#aBoard");
		return;
	}
	if(year=="") {
		baAlert("#aYear");
		return;
	}
	if(overall=="") {
		baAlert("#aOverall");
		return;
	}
	if(english=="" || hindi==""
		|| kannada=="" || science=="" 
		|| social=="" || math == "" 
		|| (otherName1!="Enter subject name" && other1=="" )
		|| (otherName2!="Enter subject name" && other2=="" ) ) {
		baAlert("#aSubjects");
		return;
	}
	
	localStorage.setItem("school9",school);	
	localStorage.setItem("board9",board);
	localStorage.setItem("year9",year);
	localStorage.setItem("overall9",overall);
	localStorage.setItem("english9",english);	
	localStorage.setItem("hindi9",hindi);	
	localStorage.setItem("kannada9",kannada);
	localStorage.setItem("math9",math);
	localStorage.setItem("science9",science);
	localStorage.setItem("social9",social);
	localStorage.setItem("othern19",otherName1);
	localStorage.setItem("othern29",otherName2);
	localStorage.setItem("other19",other1);	
	localStorage.setItem("other29",other2);	
	
	window.location.href="a3.html";
}

function deleteWM(id) {
	var element = document.getElementById(id);
	if (element.value == "Enter subject name" ) {
		element.style.color="#000000";
		element.value="";
	}
}

function reset(id) {
	var element = document.getElementById(id);
	if(element.value=="") {
		element.style.color="#D1D0CE";
		element.value="Enter subject name";
	}
}


function submitX() {
	var skip = document.getElementById("skip").checked;
	if(skip) {
		window.location.href="a8.html";
		return;
	}
	var school  = document.getElementById("schoolX").value;
	var board   = document.getElementById("boardX").value;
	var year    = document.getElementById("yearX").value;
	var overall = document.getElementById("totalX").value;
	var english = document.getElementById("englishX").value;
	var hindi   = document.getElementById("hindiX").value;
	var kannada = document.getElementById("kannadaX").value;
	var science = document.getElementById("scienceX").value;
	var math    = document.getElementById("mathsX").value;
	var social  = document.getElementById("socialX").value;
	var otherName1  = document.getElementById("other1Xn").value;
	var otherName2  = document.getElementById("other2Xn").value;
	var other1  = document.getElementById("other1X").value;
	var other2  = document.getElementById("other2X").value;
	
	if(school=="") {
		baAlert("#aSchool");
		return;
	}
	if(board=="") {
		baAlert("#aBoard");
		return;
	}
	if(year=="") {
		baAlert("#aYear");
		return;
	}
	if(overall=="") {
		baAlert("#aOverall");
		return;
	}
	if(english=="" || hindi==""
		|| kannada=="" || science=="" 
		|| social=="" || math == "" 
		|| (otherName1!="Enter subject name" && other1=="" )
		|| (otherName2!="Enter subject name" && other2=="" ) ) {
		baAlert("#aSubjects");
		return;
	}
	
	localStorage.setItem("schoolX",school);	
	localStorage.setItem("boardX",board);
	localStorage.setItem("yearX",year);
	localStorage.setItem("overallX",overall);
	localStorage.setItem("englishX",english);	
	localStorage.setItem("hindiX",hindi);	
	localStorage.setItem("kannadaX",kannada);
	localStorage.setItem("mathX",math);
	localStorage.setItem("scienceX",science);
	localStorage.setItem("socialX",social);
	localStorage.setItem("othern1X",otherName1);
	localStorage.setItem("othern2X",otherName2);
	localStorage.setItem("other1X",other1);	
	localStorage.setItem("other2X",other2);	
	
	window.location.href="a4.html";	
}

function submitXI() {
	var skip = document.getElementById("skip").checked;
	if(skip) {
		window.location.href="a8.html";
		return;
	}
	var school  = document.getElementById("schoolXI").value;
	var board   = document.getElementById("boardXI").value;
	var year    = document.getElementById("yearXI").value;
	var overall = document.getElementById("totalXI").value;
	var english = document.getElementById("englishXI").value;
	var hindi   = document.getElementById("hindiXI").value;
	var kannada = document.getElementById("kannadaXI").value;
	
	var otherName1  = document.getElementById("oth1XIn").value;
	var otherName2  = document.getElementById("oth2XIn").value;
	var otherName3  = document.getElementById("oth3XIn").value;
	var otherName4  = document.getElementById("oth4XIn").value;
	var other1  = document.getElementById("oth1XI").value;
	var other2  = document.getElementById("oth2XI").value;
	var other3  = document.getElementById("oth3XI").value;
	var other4  = document.getElementById("oth4XI").value;
	
	if(school=="") {
		baAlert("#aSchool");
		return;
	}
	if(board=="") {
		baAlert("#aBoard");
		return;
	}
	if(year=="") {
		baAlert("#aYear");
		return;
	}
	if(overall=="") {
		baAlert("#aOverall");
		return;
	}
	if(english=="" || hindi==""
		|| kannada=="" 
		|| (otherName1!="Enter subject name" && other1=="" )
		|| (otherName2!="Enter subject name" && other2=="" ) 
		|| (otherName3!="Enter subject name" && other3=="" )
		|| (otherName4!="Enter subject name" && other4=="" )) {
		baAlert("#aSubjects");
		return;
	}
	
	localStorage.setItem("schoolXI",school);	
	localStorage.setItem("boardXI",board);
	localStorage.setItem("yearXI",year);
	localStorage.setItem("overallXI",overall);
	localStorage.setItem("englishXI",english);	
	localStorage.setItem("hindiXI",hindi);	
	localStorage.setItem("kannadaXI",kannada);
	localStorage.setItem("othern1XI",otherName1);
	localStorage.setItem("othern2XI",otherName2);
	localStorage.setItem("othern3XI",otherName3);
	localStorage.setItem("othern4XI",otherName4);
	localStorage.setItem("other1XI",other1);	
	localStorage.setItem("other2XI",other2);
	localStorage.setItem("other3XI",other3);	
	localStorage.setItem("other4XI",other4);	

	
	window.location.href="a5.html";
}

function submitXII() {
	var skip = document.getElementById("skip").checked;
	if(skip) {
		window.location.href="a8.html";
		return;
	}
	var school  = document.getElementById("schoolXII").value;
	var board   = document.getElementById("boardXII").value;
	var year    = document.getElementById("yearXII").value;
	var overall = document.getElementById("totalXII").value;
	var english = document.getElementById("englishXII").value;
	var hindi   = document.getElementById("hindiXII").value;
	var kannada = document.getElementById("kannadaXII").value;
	
	var otherName1  = document.getElementById("oth1XIIn").value;
	var otherName2  = document.getElementById("oth2XIIn").value;
	var otherName3  = document.getElementById("oth3XIIn").value;
	var otherName4  = document.getElementById("oth4XIIn").value;
	var other1  = document.getElementById("oth1XII").value;
	var other2  = document.getElementById("oth2XII").value;
	var other3  = document.getElementById("oth3XII").value;
	var other4  = document.getElementById("oth4XII").value;
	
	if(school=="") {
		baAlert("#aSchool");
		return;
	}
	if(board=="") {
		baAlert("#aBoard");
		return;
	}
	if(year=="") {
		baAlert("#aYear");
		return;
	}
	if(overall=="") {
		baAlert("#aOverall");
		return;
	}
	if(english=="" || hindi==""
		|| kannada==""
		|| (otherName1!="Enter subject name" && other1=="" )
		|| (otherName2!="Enter subject name" && other2=="" ) 
		|| (otherName3!="Enter subject name" && other3=="" )
		|| (otherName4!="Enter subject name" && other4=="" )) {
		baAlert("#aSubjects");
		return;
	}	
	
	localStorage.setItem("schoolXII",school);	
	localStorage.setItem("boardXII",board);
	localStorage.setItem("yearXII",year);
	localStorage.setItem("overallXII",overall);
	localStorage.setItem("englishXII",english);	
	localStorage.setItem("hindiXII",hindi);	
	localStorage.setItem("kannadaXII",kannada);
	localStorage.setItem("othern1XII",otherName1);
	localStorage.setItem("othern2XII",otherName2);
	localStorage.setItem("othern3XII",otherName3);
	localStorage.setItem("othern4XII",otherName4);
	localStorage.setItem("other1XII",other1);	
	localStorage.setItem("other2XII",other2);
	localStorage.setItem("other3XII",other3);	
	localStorage.setItem("other4XII",other4);
	
	window.location.href="a6.html";
}

function incomplete(a,b,c) {
	return (a == "" && (b != "" || c != "")) ||
		   (b == "" && (c != "" || a != "")) ||
		   (c == "" && (a != "" || b != ""));
		
}

function submitCompExam() {
	var skip = document.getElementById("skip").checked;
	if(skip) {
		window.location.href="a8.html";
		return;
	}
	var comp1  = document.getElementById("comp1").value;
	var cy1  = document.getElementById("cy1").value;
	var ry1  = document.getElementById("ry1").value;
	if(incomplete(comp1,cy1,ry1)) {
		baAlert("#incomp");
		return;
	}
	
	
	var comp2  = document.getElementById("comp2").value;
	var cy2  = document.getElementById("cy2").value;
	var ry2  = document.getElementById("ry2").value;
	if(incomplete(comp2,cy2,ry2)) {
		baAlert("#incomp");
		return;
	}
	
	var comp3  = document.getElementById("comp3").value;
	var cy3  = document.getElementById("cy3").value;
	var ry3  = document.getElementById("ry3").value;
	if(incomplete(comp3,cy3,ry3)) {
		baAlert("#incomp");
		return;
	}
	
	var comp4  = document.getElementById("comp4").value;
	var cy4  = document.getElementById("cy4").value;
	var ry4  = document.getElementById("ry4").value;
	if(incomplete(comp4,cy4,ry4)) {
		baAlert("#incomp");
		return;
	}
	
	var comp5  = document.getElementById("comp5").value;		
	var cy5  = document.getElementById("cy4").value;					
	var ry5  = document.getElementById("ry4").value;
	if(incomplete(comp5,cy5,ry5)) {
		baAlert("#incomp");
		return;
	}
	
	if(comp1=="" && comp2=="" && comp3=="" && comp4=="" && comp5 == "") {
		baAlert("#empty");
		return;
	}
	localStorage.setItem("comp1",comp1);
	localStorage.setItem("cy1",cy1);
	localStorage.setItem("ry1",ry1);
	localStorage.setItem("comp2",comp2);
	localStorage.setItem("cy2",cy2);
	localStorage.setItem("ry2",ry2);
	localStorage.setItem("comp3",comp3);
	localStorage.setItem("cy3",cy3);
	localStorage.setItem("ry3",ry3);
	localStorage.setItem("comp4",comp4);
	localStorage.setItem("cy4",cy4);
	localStorage.setItem("ry4",ry4);
	localStorage.setItem("comp5",comp5);
	localStorage.setItem("cy5",cy5);
	localStorage.setItem("ry5",ry5);

	window.location.href = "a7.html";	
}

function submitHigher() {
	
	var skip = document.getElementById("skip").checked;
	if(skip) {
		window.location.href="a8.html";
		return;
	}
	
	var collegeName = document.getElementById("college_name").value;
	var courseName = document.getElementById("course_name").value;
	var grad1s = document.getElementById("grad1s").value;
	var grad1e = document.getElementById("grad1e").value;
	var grad1p = document.getElementById("grad1p").value;
	var grad2s = document.getElementById("grad2s").value;
	var grad2e = document.getElementById("grad2e").value;
	var grad2p = document.getElementById("grad2p").value;
	var grad3s = document.getElementById("grad3s").value;
	var grad3e = document.getElementById("grad3e").value;
	var grad3p = document.getElementById("grad3p").value;
	var grad4s = document.getElementById("grad4s").value;
	var grad4e = document.getElementById("grad4e").value;
	var grad4p = document.getElementById("grad4p").value;
	var hcomments = document.getElementById("hcomments").value;
	
	if(collegeName=="" || courseName=="") {
		baAlert("#dialog1");
		return;
	}

	localStorage.setItem("gradCollege",collegeName);
	localStorage.setItem("gradCourse", courseName);
	localStorage.setItem("grad1s",grad1s);
	localStorage.setItem("grad1e",grad1e);
	localStorage.setItem("grad1p",grad1p);
	localStorage.setItem("grad2s",grad2s);
	localStorage.setItem("grad2e",grad2e);
	localStorage.setItem("grad2p",grad2p);
	localStorage.setItem("grad3s",grad3s);
	localStorage.setItem("grad3e",grad3e);
	localStorage.setItem("grad3p",grad3p);
	localStorage.setItem("grad4s",grad4s);
	localStorage.setItem("grad4e",grad4e);
	localStorage.setItem("grad4p",grad4p);		
	localStorage.setItem("hcomments",hcomments);
	baConfirm("#dialog2","a8.html");
	
}

function submitTuition() {
	var tuition = document.getElementById("tuition").value;
	var skip = document.getElementById("skip").checked;
	if(skip) {		
		localStorage.setItem("tuition","I haven't attended any extra tuition or coaching.");
	}
	else if(!skip && tuition=="") {
		baConfirm("#dialog2", "a9.html");
		localStorage.setItem("tuition","");
		return;
	}
	else {
		localStorage.setItem("tuition",tuition);		
	}
	window.location.href = "a9.html";	
}



function submitFailureChanges() {
	var fail_change = document.getElementById("fail_change").value;
	var skip = document.getElementById("skip").checked;
	if(skip) {		
		localStorage.setItem("failChange","There are no failures or course changes.");
	}
	else if(!skip && fail_change=="") {
		baConfirm("#dialog2", "b10.html");
		localStorage.setItem("failChange","");
		return;
	}
	else {
		localStorage.setItem("failChange",fail_change);		
	}
	window.location.href = "b10.html";	
}

function submitCounselling() {
	var yes  = document.getElementById("cyes").checked;
	var no   = document.getElementById("cno").checked;
	var desc = document.getElementById("counselling_desc").value;  

	if(!yes && !no ) {
		baAlert("#dialog3");
		return;
	}

	if(no) {
		localStorage.setItem("wantCounselling", "No");
		localStorage.setItem("counsellingReason","I don't want counselling.");
	}
	else {
		localStorage.setItem("wantCounselling", "Yes");
		if(desc=="") {			
			localStorage.setItem("counsellingReason","");
			baConfirm("#dialog2", "b11.html");
			return;
		}
		else
			localStorage.setItem("counsellingReason", desc);
	}
	
	window.location.href = "b11.html";
}

function submitChange() {
	var skip = document.getElementById("skip").checked;
	var scchange = document.getElementById("scchange").value;
	localStorage.setItem("schoolCollegeChange", scchange);
	if(!skip && scchange=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "b112.html";
}

function submitLikeDislike() {
	var likedis = document.getElementById("likedis").value;
	localStorage.setItem("likeDislike", likedis);
	if(likedis=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "b12.html";
}

function submitSkills() {
	var oskills = document.getElementById("oskills").value;
	localStorage.setItem("oskills", oskills);
	if(oskills=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "b13.html";
}

function submitRelive() {
	var relive = document.getElementById("relive").value;
	localStorage.setItem("relive", relive);
	if(relive =="") {			
		baConfirm("#dialog2","b14.html");
		return;
	}
	window.location.href = "b14.html";
}

function submitSongs() {
	var songs = document.getElementById("songs").value;
	localStorage.setItem("songs", songs);
	if(songs=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "b15.html";
}

function submitPets() {
	var pets = document.getElementById("pets").value;
	localStorage.setItem("pets", pets);
	if(pets=="") {			
		baAlert("#dialog2");	
		return;
	}
	window.location.href = "b16.html";
}

function submitLang() {
	var lang = document.getElementById("lang").value;
	localStorage.setItem("lang", lang);
	if(lang=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "b17.html";
}

function submitGoodQual() {
	var gq1 = document.getElementById("good_quality1").value;
	var gq2 = document.getElementById("good_quality2").value;
	var gq3 = document.getElementById("good_quality3").value;
	if(gq1=="First ..." || gq2=="Second ..." || gq3=="Third ...") {
		baAlert("#dialog2");
		return;
	}
	localStorage.setItem("gq1", gq1);
	localStorage.setItem("gq2", gq2);
	localStorage.setItem("gq3", gq3);
	window.location.href = "b18.html";
}

function submitBadQual() {
	var bq1 = document.getElementById("bad_quality1").value;
	var bq2 = document.getElementById("bad_quality2").value;
	var bq3 = document.getElementById("bad_quality3").value;
	if(bq1=="First ..." || bq2=="Second ..." || bq3=="Third ...") {
		baAlert("#dialog2");
		return;
	}
	localStorage.setItem("bq1", bq1);
	localStorage.setItem("bq2", bq2);
	localStorage.setItem("bq3", bq3);
	window.location.href = "b19.html";
}

function submitComments() {
	var comments = document.getElementById("others_comments").value;
	localStorage.setItem("othersComments", comments);
	if(comments=="") {			
		baAlert("#dialog2");
		return;
	}
	window.location.href = "c20.html";
}

function submitExtraCur() {
	var extraCur = document.getElementById("extra_curriculars").value;
	localStorage.setItem("extraCurriculars", extraCur);
	if(extraCur=="") {
		baAlert("#dialog2");
		return;
	}
	window.location.href = "c21.html";
}

function submitParentInfo() {
	var mother_name = document.getElementById("mother_name").value;
	if(mother_name=="") {
		baAlert("#mother");
		return;
	}
		
	var mother_qualification = document.getElementById("mother_qualification").value;
	if(mother_qualification == "") {
		baAlert("#mother");
		return;
	}

	var mother_occupation = document.getElementById("mother_occupation").value;
	if(mother_occupation=="") {
		baAlert("#mother");
		return;
	}
	
	var father_name = document.getElementById("father_name").value;
	if(father_name == "") {
		baAlert("#father");
		return;
	}
	
	var father_qualification = document.getElementById("father_qualification").value;
	if(father_qualification=="") {
		baAlert("#father");
		return;
	}
	
	var father_occupation = document.getElementById("father_occupation").value;
	if(father_occupation=="") {
		baAlert("#father");
		return;
	}
	
	localStorage.setItem("motherName", mother_name);
	localStorage.setItem("motherQual", mother_qualification);
	localStorage.setItem("motherProf", mother_occupation);
	localStorage.setItem("fatherName", father_name);
	localStorage.setItem("fatherQual", father_qualification);
	localStorage.setItem("fatherProf", father_occupation);
	
	window.location.href = "c22.html";
}

function submitRoleModel() {
	var roleModel = document.getElementById("role_model").value;
	if(roleModel=="") {
		baAlert("#dialog2");
		return;
	}
	localStorage.setItem("roleModel", roleModel);
	window.location.href = "c23.html";
}
function submitFavPerson() {
	var favPerson = document.getElementById("fav_teacher_friend").value;
	if(favPerson=="") {
		baAlert("#dialog2");
		return;
	}
	localStorage.setItem("favPerson", favPerson);
	window.location.href = "c24.html";
}

function submitCompUse() {
	var browsing = document.getElementById("browsing").checked;
	if(browsing)
		localStorage.setItem("browsing","yes");
	var games = document.getElementById("games").checked;
	if(games)
		localStorage.setItem("games","yes");
	var social = document.getElementById("social").checked;
	if(social)
		localStorage.setItem("social","yes");
	var creative = document.getElementById("creative").checked;
	if(creative)
		localStorage.setItem("creative","yes");
	var coding = document.getElementById("coding").checked;
	if(coding)
		localStorage.setItem("coding","yes");
	var otheracts = document.getElementById("otheracts").checked;
	if(otheracts) {
		localStorage.setItem("otheracts","yes");
		var others = document.getElementById("other_activities").value;
		if(others=="") {
			baAlert("#NoOthers");
			return;
		}
		localStorage.setItem("otherActivities", others);
	}	
	
	if(!(browsing || games || social || creative || coding || otheracts)) {
		baAlert("#NoSel");
		return;
	}
	window.location.href = "c25.html";
}

function submitEngDocAns() {
	var engdoc = document.getElementById("engdoc").value;
	if(engdoc=="") {
		baAlert("#NoAnswer");
		return;
	}
	localStorage.setItem("engdoc", engdoc);
	window.location.href = "c26.html";
}

function submitCareerChoice() {
	var name = document.getElementById("profession1_name").value;
	var reason = document.getElementById("profession1_reason").value; 
	var courses = document.getElementById("profession1_courses").value;
	var subjects = document.getElementById("profession1_subjects").value;
	var skills = document.getElementById("profession1_skills").value;
	var job = document.getElementById("profession1_job").value;
	if(name=="" || reason =="" || courses == "" || subjects ==""
		|| skills=="" || job == "") {
		baAlert("#incomp");
		return;
	}
	localStorage.setItem("p1name",name);
	localStorage.setItem("p1reason",reason);
	localStorage.setItem("p1courses",courses);
	localStorage.setItem("p1subjects",subjects);
	localStorage.setItem("p1skills",skills);
	localStorage.setItem("p1job",job);
	
	name = document.getElementById("profession2_name").value;
	reason = document.getElementById("profession2_reason").value; 
	courses = document.getElementById("profession2_courses").value;
	subjects = document.getElementById("profession2_subjects").value;
	skills = document.getElementById("profession2_skills").value;
	job = document.getElementById("profession2_job").value;
	if(name=="" || reason =="" || courses == "" || subjects ==""
		|| skills=="" || job == "") {
		baAlert("#incomp");
		return;
	}
	localStorage.setItem("p2name",name);
	localStorage.setItem("p2reason",reason);
	localStorage.setItem("p2courses",courses);
	localStorage.setItem("p2subjects",subjects);
	localStorage.setItem("p2skills",skills);
	localStorage.setItem("p2job",job);
	
	window.location.href = "c28.html";
}


function submitParentChoice() {
	var parentChoice = document.getElementById("pcareerchoice").value;
	if(parentChoice=="") {
		baAlert("#incomp");
		return;
	}
	localStorage.setItem("parentChoice", parentChoice);
	window.location.href = "c281.html";
}

function submitAchievement() {
	var greatestAchievement = document.getElementById("gachieve").value;
	if(greatestAchievement=="") {
		baAlert("#incomp");
		return;
	}
	localStorage.setItem("greatAchieve", greatestAchievement);
	window.location.href = "c29.html";
}

function submitRIT() {
	var rit1 = document.getElementById("rit1").value;
	var place_how = document.getElementById("place_how").value;
	if((rit1=="3" || rit1=="2") && (place_how=="" || place_how=="Please tell us how...")) {
		baAlert("#error1");
		return;
	}
	
	var rit2 = document.getElementById("rit2").value;
	var food_how = document.getElementById("food_how").value;
	if((rit2=="3" || rit2=="2") && (food_how=="" || food_how=="Please tell us how...")) {
		baAlert("#error2");
		return;
	}


	var rit3 = document.getElementById("rit3").value;
	var civ_how = document.getElementById("civ_how").value;
	if((rit3=="3" || rit3=="2") && (civ_how=="" || civ_how=="Please tell us how...")) {
		baAlert("#error3");
		return;
	}
	
	
	var rit4 = document.getElementById("rit4").value;
	var rit5 = document.getElementById("rit5").value;
	var rit6 = document.getElementById("rit6").value;
	var rit7 = document.getElementById("rit7").value;
	var rit8 = document.getElementById("rit8").value;
	var rit9 = document.getElementById("rit9").value;
	if(rit1=="" || rit2=="" || rit3=="" || rit4==""
		|| rit5=="" || rit6=="" || rit7=="" || rit8 =="" || rit9 =="") {
		baAlert("#error4");
		return;
	}
	var rit10 = document.getElementById("rit10").value;
	if(rit10 == "") {
		baAlert("#error5");
		return;
	}
	
	var rit_other = document.getElementById("rit_other").value;
	if(rit_other == "") {
		baAlert("#error6");
		return;
	}
	localStorage.setItem("rit1", rit1);
	localStorage.setItem("place_how", place_how);
	localStorage.setItem("rit2", rit2);
	localStorage.setItem("food_how", food_how);
	localStorage.setItem("rit3", rit3);
	localStorage.setItem("civ_how", civ_how);
	localStorage.setItem("rit4", rit4);
	localStorage.setItem("rit5", rit5);
	localStorage.setItem("rit6", rit6);
	localStorage.setItem("rit7", rit7);
	localStorage.setItem("rit8", rit8);
	localStorage.setItem("rit9", rit9);	
	localStorage.setItem("rit10", rit10);
	localStorage.setItem("rit_other", rit_other);
	
	window.location.href = "thank_you.html";
}

function baAlert(messageDiv) {
	$( messageDiv ).dialog({
		title: "Sorry!",
		width: 400,
		height: 150,		
	}).css("font-size","15px").prev(".ui-dialog-titlebar").css("background","red");
}


function baConfirm(messageDiv, okPage) {
	 $(messageDiv).dialog({
		 title: "No response!",		 
		 width: 400,
         height: 200,
	      buttons : {
	        "Yes" : function() {	        
	        	window.location.href = okPage;
	        	$(this).dialog("close");
	        },
	        "No" : function() {
	        	$(this).dialog("close");
	        }
	      }
	    }).css("font-size","15px").prev(".ui-dialog-titlebar").css("background","red");;
}


function askOthers() {	
	var set = document.getElementById("otheracts").checked;
	if(set==true)
		document.getElementById("other_activities_div").style.display = 'inline';
	else
		document.getElementById("other_activities_div").style.display = 'none';
}


