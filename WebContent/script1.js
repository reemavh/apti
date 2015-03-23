var index = -1;
var array=[];
function begin() {
	var divId = 0;	
	for(var i=1;i<=142; i++)
		if(i != 129 && i!=130)
			array.push(i);
	schuffle(array); 
	array.splice(65, 0, 143);
	array.splice(70, 0, 144);
	array.splice(120,0,145);
	array.splice(125,0,146);	
	array.push(147);
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
}

function endTest() {
	window.location.href="d31.html";
}
function ieAns(num) {
	if(!ynValidate(num)) {
		baAlert("Please select one of the two options!");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
	var key = "ie"+divId;
	var val = getYN(num);
	localStorage.setItem(key,val);
}

function dsAns(num) {
	if(!ynValidate(num)) {
		baAlert("Please select one of the two options!");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
	var key = "ds"+(divId-20);
	var val = getYN(num);
	localStorage.setItem(key,val);
}

function bmAns(num) {
	if(!asmvValidate(num)) {
		baAlert("Please select one of the four options!");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';	
	var key = "bm"+(divId-40);
	var val = getASMV(num);
	localStorage.setItem(key,val);
}

function blrAns(num) {
	if(!aornValidate(num)) {
		baAlert("Please select one of the four options!");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';	
	var key = "blr"+(divId-65);
	var val = getAORN(num);
	localStorage.setItem(key,val);
}

function tiqAns(num) {
	var ans;
	if(num==105)      ans = getMatches();
	else if(num==107) ans = getDirection();
	else if(num==110) ans = getTIQText(num);
	else if(num==111) ans = getTIQText(num);
	else if(num==112) ans = getPic();
	else              ans = getTIQ(num);
	
	if(ans == "null") return;

	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
	//tiq[divId-97] = ans;
	var key = "tiq"+(divId-97);
	var val = ans;
	localStorage.setItem(key,val);
}
function gatlAns(num) {	
	var divId;
	var nextDivId;

	if(num==128) {
		var ans = getGatlAnswer(num);
		if(ans=="null") {
			baAlert("Please select one of the five options");
			return;
		}
		//gatl[1] = ans;
		localStorage.setItem("gatl1", ans);
		ans = getGatlAnswer(num+1);
		if(ans=="null") {
			baAlert("Please select one of the five options");
			return;
		}
		//gatl[2] = ans;
		localStorage.setItem("gatl2", ans);
		
		ans = getGatlAnswer(num+2);
		if(ans=="null") {
			baAlert("Please select one of the five options");
			return;
		}
		//gatl[3] = ans;
		localStorage.setItem("gatl3", ans);
		
		divId = num;
		nextDivId = array[++index];

	}
	else {
		var ans = getGatlAnswer(num);
		if(ans=="null") {
			baAlert("Please select one of the five options");
			return;
		}
		
		//gatl[num-127] = ans;		
		var key = "gatl" + (num-127);
		localStorage.setItem(key, ans);
		
		divId = num;
		nextDivId = array[++index];
	}
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';	
}

function gatmAns(num) {
	var answer;
	if(num==114 || num==124 || num==127) {
		answer=getGATMText(num);
		if(answer=="null") {
			baAlert("Please enter an answer.");
			return;
		}
	}
	else if(num==125) {
		answer=getAges(num);
		if(answer=="null") {
			baAlert("You haven't supplied at least one answer.");
			return;
		}
	}
	else{
		answer=getGATMAns(num);
		if(answer=="null") {
			baAlert("Please select one of the five options.");
			return;
		}
	}		
	//gatl[num-112] = answer;	
	var key = "gatm" + (num-112);	
	localStorage.setItem(key, answer);
	
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
	
}

function nextQuestion(num) {
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
	
}

function submitTW(num) {
	var count = 0;
	var tw1 = document.getElementById("tw1").value;
	if(tw1=="") count++;
	localStorage.setItem("tw1", tw1);
	
	var tw2 = document.getElementById("tw2").value;
	if(tw2=="") count++;
	localStorage.setItem("tw2", tw2);
	
	var tw3 = document.getElementById("tw3").value;
	if(tw3=="") count++;
	localStorage.setItem("tw3", tw3);
	
	var tw4 = document.getElementById("tw4").value;
	if(tw4=="") count++;
	localStorage.setItem("tw4", tw4);
	
	var tw5 = document.getElementById("tw5").value;
	if(tw5=="") count++;
	localStorage.setItem("tw5", tw5);
	
	var tw6 = document.getElementById("tw6").value;
	if(tw6=="") count++;
	localStorage.setItem("tw6", tw6);
	
	var tw7 = document.getElementById("tw7").value;
	if(tw7=="") count++;
	localStorage.setItem("tw7", tw7);
	
	var tw8 = document.getElementById("tw8").value;
	if(tw8=="") count++;
	localStorage.setItem("tw8", tw8);
	
	var tw9 = document.getElementById("tw9").value;
	if(tw9=="") count++;
	localStorage.setItem("tw9", tw9);
	
	var tw10 = document.getElementById("tw10").value;
	if(tw10=="") count++;
	localStorage.setItem("tw10", tw10);
	
	if(count > 5) {	
		baAlert("Please try to remember a few more words.");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
}
function submitFQ(num) {
	var count=0;
	var fq1 = document.getElementById("fq1").value;
	if(fq1=="") count++;
	localStorage.setItem("fq1", fq1);
	
	var fq2 = document.getElementById("fq2").value;
	if(fq2=="") count++;
	localStorage.setItem("fq2", fq2);
	
	var fq3 = document.getElementById("fq3").value;
	if(fq3=="") count++;
	localStorage.setItem("fq3", fq3);
	
	var fq4 = document.getElementById("fq4").value;
	if(fq4=="") count++;
	localStorage.setItem("fq4", fq4);
	
	var fq5 = document.getElementById("fq5").value;
	if(fq5=="") count++;
	localStorage.setItem("fq5", fq5);
	
	if(count > 2) {
		baAlert("Please try to remember more answers!");
		return;
	}
	var divId = num;
	var nextDivId = array[++index];
	document.getElementById(divId).style.display='none';
	document.getElementById(nextDivId).style.display='block';
}

function submitGatc() {
	var gatc1 = document.getElementById("timedn1").value;
	var gatc2 = document.getElementById("timedn2").value;
	var gatc3 = document.getElementById("timedn3").value;
	var gatc4 = document.getElementById("timedn4").value;
	var gatc5 = document.getElementById("timedn5").value;
	var gatc6 = document.getElementById("timedn6").value;
	var gatc7 = document.getElementById("timedn7").value;	
	localStorage.setItem("gatc1", gatc1);
	localStorage.setItem("gatc2", gatc2);
	localStorage.setItem("gatc3", gatc3);
	localStorage.setItem("gatc4", gatc4);
	localStorage.setItem("gatc5", gatc5);
	localStorage.setItem("gatc6", gatc6);
	localStorage.setItem("gatc7", gatc7);
	window.location.href="d32.html";
}	

function submitGatc1() {
	var gatc1wc = document.getElementById("timednw7").value;
	localStorage.setItem("gatc1wc", gatc1wc);
	window.location.href="d33.html";
}

function submitGatf() {
	
	var gatf1 = document.getElementById("untimedn1").value;	
	var gatf2 = document.getElementById("untimedn2").value;	
	var gatf3 = document.getElementById("untimedn3").value;	
	var gatf4 = document.getElementById("untimedn4").value;	
	var gatf5 = document.getElementById("untimedn5").value;	
	var gatf6 = document.getElementById("untimedn6").value;	
	var gatf7 = document.getElementById("untimedn7").value;

	if(gatf1 == "" || gatf2 == "" || gatf3 == "" || gatf4 == "" || 
			gatf5 == "" || gatf6 == "" || gatf7 == "") {
		baAlert("Please provide all the answers.");
		return;
	}
	localStorage.setItem("gatf1", gatf1);
	localStorage.setItem("gatf2", gatf2);
	localStorage.setItem("gatf3", gatf3);
	localStorage.setItem("gatf4", gatf4);
	localStorage.setItem("gatf5", gatf5);
	localStorage.setItem("gatf6", gatf6);
	localStorage.setItem("gatf7", gatf7);
	localStorage.setItem("gatfTime", totalTime);
	window.location.href="d34.html";
}

function submitGatf1() {
	var gatf1wc = document.getElementById("untimednw7").value;	

	if(gatf1wc == "") {
		baAlert("Please provide an answer.");
		return;
	}
	localStorage.setItem("gatf1wc", gatf1wc);
	localStorage.setItem("gatfwcTime", totalTime);
	alert("Total time taken in seconds = " + totalTime);
	window.location.href="d35.html";
}

function openVocTest1() {	
	var professions = ["Accountant or CA",
	                   "Advertising Work",
	                   "Aerial Photographer",
	                   "Air Hostess or Steward",
	                   "Air traffic Controller",
	                   "Airlines executive",
	                   "Anchoring or RJ or DJ",
	                   "Appraiser or valuer",
	                   "Archaeologist",
	                   "Army Officer",
	                   "Astronaut",
	                   "Athletics coach",
	                   "Banker",
	                   "Biotechnologist",
	                   "Budget or Finance planner",
	                   "Business consultant",
	                   "Cartoonist or animator",
	                   "CBI or Intelligence Officer",
	                   "Child Counselor",
	                   "City Planner",
	                   "Civil Engineer",
	                   "Commander",
	                   "Commercial Photographer",
	                   "Company director",
	                   "Computer Engineer",
	                   "Cost & Works accountant",
	                   "Counselor or psychologist",
	                   "Crime Reporter",
	                   "Department Store or Mall Manager",
	                   "Detective or Investigator",
	                   "Disease Research work",
	                   "Doctor or Para-medical",
	                   "Dog or Animal Breeder",
	                   "Economist",
	                   "Editor or journalist",
	                   "Education manager",
	                   "Entrepreneur",
	                   "Environment Specialist",
	                   "Event manager",
	                   "Explorer",
	                   "Facilities manager",
	                   "Factory Manager",
	                   "Farmer or agriculturist",
	                   "Fashion Designer",
	                   "Fighter Pilot",
	                   "Finance manager",
	                   "Fire fighter",
	                   "Film or theater Director",
	                   "Food Analyst",
	                   "Foreign exchange Specialist",
	                   "Foreign Service Officer",
	                   "Franchise developer",
	                   "Historian or Museum Mgr",
	                   "Hospital Administrator",
	                   "Hotel Manager",
	                   "HRD Manager",
	                   "IAS or KAS officer",
	                   "Insurance expert",
	                   "International Trade",
	                   "Interpreter or Translator",
	                   "Inventor or product developer",
	                   "Investment Banker",
	                   "Labor Welfare Officer",
	                   "Lawyer or legal expert",
	                   "Librarian",
	                   "Logistics or supply officer",
	                   "Marketing Professional",
	                   "Mathematician",
	                   "Mechanical Engineer",
	                   "Meteorologist",
	                   "Microbiologist",
	                   "Model or Actor",
	                   "Music composer",
	                   "NGO manager",
	                   "Social worker",
	                   "Nutrition or dietician",
	                   "Office manager",
	                   "Officer of a ship",
	                   "Pediatrician",
	                   "Pharmacist or drug mfr",
	                   "Plant specialist",
	                   "Political analyst",
	                   "Politician",
	                   "Pollution control Expert",
	                   "Portal or webpage manager",
	                   "Professional Car racing",
	                   "Projects developer",
	                   "Public Speaker",
	                   "Real Estate Developer",
	                   "Religious Leader",
	                   "Rural development mgr",
	                   "Scientific research",
	                   "Soil Scientist",
	                   "Speech therapist",
	                   "Statistician or economist",
	                   "Stock or investments ",
	                   "Structural Engineer",
	                   "Surgeon",
	                   "Systems analyst",
	                   "Systems manager",
	                   "Tax consultant",
	                   "Teacher or educationist",
	                   "Team leader",
	                   "Theatre Set Designer",
	                   "Tourism guide",
	                   "Trader or dealer",
	                   "Training Administrator",
	                   "Travel agent or Executive",
	                   "TV Script writer",
	                   "Veterinarian",
	                   "Wild life Specialist",
	                   "Writer or publisher"];
		var count=0;
		var selected = "";
		var selectIndex = "";
		for(var i=1; i<=112;i++) {
			var id = "voc"+i;
			if(document.getElementById(id).checked) {				
				count++;
				selected += professions[i-1]+"|";	
				selectIndex += i + "|";
			}
		}
		
		localStorage.setItem("vocAll", selectIndex);
			
		document.cookie = "voc1="+selected; //need to change to concat
		alert(selectIndex);
		window.location.href="d36.html";
		return;
}
function submitVoc2() {
	var checkedCount=0;
	var twoVoc="";
	
	for(var i=1; i<=count; i++) {
		var id = "vocp" + i;		
		if(document.getElementById(id).checked) {
			checkedCount++;
			var lab = "lab_"+id;
			twoVoc += (document.getElementById(lab).innerHTML) +"|";
		}		
	}
	if(checkedCount > 2) {
		baAlert("Please select only two vocations.");
		return;
	}
	alert(twoVoc);
	localStorage.setItem("vocTwo", twoVoc);
	window.location.href="d37.html";
}

function submitISI() {
	var i=1;
	var isiAns="";
	for(; i<=30; i++) {
		if(document.getElementById("isi"+i).checked)
			isiAns += (i+"|");
	}
	localStorage.setItem("isi", isiAns);
	alert(isiAns);
	window.location.href="d38.html";
}

function submitPrize() {
	var prize = document.getElementById("prize").value;
	if(prize.length < 200) {
		baAlert("Please try to elaborate more.");
		return;
	}
	localStorage.setItem("prize", prize);
	window.location.href="d39.html";
}

function submitDirections() {
	var directions = document.getElementById("directions").value;
	if(directions.length < 50) {
		baAlert("Please try to elaborate more.");
		return;
	}
	localStorage.setItem("directions", directions);
	window.location.href="e40.html";
}

function submitBicycle() {
	var bicycle = document.getElementById("bicycle").value;
	if(bicycle.length < 100) {
		baAlert("Please try to elaborate more.");
		return;
	}
	localStorage.setItem("bicycle", bicycle);
	window.location.href="e41.html";
}

function submitIncident() {
	var incident = document.getElementById("incident").value;
	if(incident.length < 200) {
		baAlert("Please try to elaborate more.");
		return;
	}
	localStorage.setItem("incident", incident);
	window.location.href="e42.html";
}

function submitPicture() {
	var picture = document.getElementById("picture").value;
	if(picture.length < 350) {
		baAlert("Please try to elaborate more.");
		return;
	}
	localStorage.setItem("picture", picture);
	window.location.href="e43.html";
}


////////////////////////////////////////////////////////////////////
function getAges(num) {
	var divIda = "gatm" + num + "a";
	var divIdb = "gatm" + num + "b";
	var ageA = document.getElementById(divIda).value;
	var ageB = document.getElementById(divIdb).value;
	if(ageA==""|| ageB=="")
		return "null";
	else
		return ageA + "-" + ageB;	
}

function getGATMText(num) {
	var divId = "gatm" + num;
	var txt = document.getElementById(divId).value;
	if(txt=="") 	
		return "null";
	return txt;
}

function getGATMAns(num) {
	var divId = "gatm" + num;
	var a = document.getElementById(divId+"a").checked;
	var b = document.getElementById(divId+"b").checked;
	var c = document.getElementById(divId+"c").checked;
	var d = document.getElementById(divId+"d").checked;
	var e = document.getElementById(divId+"e").checked;
	if((a||b||c||d||e) == false) {
		return "null";
	}
	if(a) return "a";
	if(b) return "b";
	if(c) return "c";
	if(d) return "d";
	return "e";
}

function getGatlAnswer(num) {
	var divId = "gatl" + num;
	var a = document.getElementById(divId+"a").checked;
	var b = document.getElementById(divId+"b").checked;
	var c = document.getElementById(divId+"c").checked;
	var d = document.getElementById(divId+"d").checked;
	var e = document.getElementById(divId+"e").checked;
	if((a||b||c||d||e) == false) {
		return "null";
	}
	if(a) return "a";
	if(b) return "b";
	if(c) return "c";
	if(d) return "d";
	return "e";	
}
function getMatches() {
	var col1 = document.getElementById("mcol1").value;
	var col2 = document.getElementById("mcol2").value;
	var col3 = document.getElementById("mcol3").value;
	var col4 = document.getElementById("mcol4").value;
	var col5 = document.getElementById("mcol5").value;
	if(col1=="" || col2=="" || col3=="" || col4=="" || col5=="") {
		baAlert("Please ensure you selected an answer for each of the triplets.");
		return "null";
	}
	var txt = "1" + col1 + "-" + 
	          "2" + col2 + "-" + 
	          "3" + col3 + "-" +
	          "4" + col4 + "-" + 
	          "5" + col5;
	return txt;
}

function getDirection() {
	var a = document.getElementById("tiq107a").checked;
	var b = document.getElementById("tiq107b").checked;
	var c = document.getElementById("tiq107c").checked;
	var d = document.getElementById("tiq107d").checked;
	if((a||b||c||d) == false) {
		baAlert("Please select one of the four options");
		return "null";
	}
	if(a) return "a";
	if(b) return "b";
	if(c) return "c";
	return "d";
}

function getPic() {
	var a = document.getElementById("tiq112a").checked;
	var b = document.getElementById("tiq112b").checked;
	var c = document.getElementById("tiq112c").checked;
	if((a||b||c) == false) {
		baAlert("Please select one of the three options");
		return "null";
	}
	if(a) return "a";
	if(b) return "b";
	return "c";	
}

function getTIQText(num) {
	var divId = "tiq" + num;
	var txt = document.getElementById(divId).value;
	if(txt=="") {
		baAlert("Please enter an answer.");
		return "null";
	}	
	return txt;
}

function getTIQ(num) {
	var divId = "tiq" + num;
	var a = document.getElementById(divId+"a").checked;
	var b = document.getElementById(divId+"b").checked;
	var c = document.getElementById(divId+"c").checked;
	var d = document.getElementById(divId+"d").checked;
	var e = document.getElementById(divId+"e").checked;
	if((a||b||c||d||e) == false) {
		baAlert("Please select one of the five options");
		return "null";
	}
	if(a) return "a";
	if(b) return "b";
	if(c) return "c";
	if(d) return "d";
	return "e";
}

function ynValidate(num) {
	var yes = "yn" + num+ "y";
	var no  = "yn" + num+ "n";
	return ((document.getElementById(yes).checked == true)
	   || (document.getElementById(no).checked == true));
}

function getYN(num) {
	var yes = "yn" + num+ "y";
	if(document.getElementById(yes).checked == true)
		return "yes";
	else
		return "no";
}

function asmvValidate(num) {
	var always = "asmv" + num+ "a";
	var sometimes = "asmv" + num+ "s";
	var mostly = "asmv" + num+ "m";
	var veryrare = "asmv" + num+ "v";
	
	return ((document.getElementById(always).checked == true)
	   || (document.getElementById(sometimes).checked == true)
	   || (document.getElementById(mostly).checked == true)
	   || (document.getElementById(veryrare).checked == true));
}

function getASMV(num) {
	var always = "asmv" + num+ "a";
	var mostly = "asmv" + num+ "s";
	var sometimes = "asmv" + num+ "m";
	
	if(document.getElementById(always).checked == true)
		return "always";
	else if (document.getElementById(sometimes).checked == true)
		return "sometimes";
	else if (document.getElementById(mostly).checked == true)
		return "mostly";
	else
		return "very-rarely";
}

function aornValidate(num) {
	var always = "aorn" + num+ "a";
	var often = "aorn" + num+ "o";
	var rarely = "aorn" + num+ "r";
	var never = "aorn" + num+ "n";
	
	return ((document.getElementById(always).checked == true)
	   || (document.getElementById(often).checked == true)
	   || (document.getElementById(rarely).checked == true)
	   || (document.getElementById(never).checked == true));
}

function getAORN(num) {
	var always = "aorn" + num+ "a";
	var often = "aorn" + num+ "o";
	var rarely = "aorn" + num+ "r";
	
	if(document.getElementById(always).checked == true)
		return "always";
	else if (document.getElementById(often).checked == true)
		return "often";
	else if (document.getElementById(rarely).checked == true)
		return "rarely";
	else
		return "never";
}


function getCookie(cname) {
	
    var name = cname + "=";
    alert(name);
    var ca = document.cookie.split('+');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) 
        	return c.substring(name.length, c.length);
    }
    return "";
}

function baAlert(message) {
	document.getElementById("errorDiv").innerHTML = message;
	$( "#errorDiv" ).dialog({
		title: "Sorry!",
		width: 400,
		height: 150,		
	}).css("font-size","15px").prev(".ui-dialog-titlebar").css("background","red");
}

function schuffle(array) {
	var i = array.length;
	if ( i == 0 ) return false;
	  while ( --i ) {
	     var j = Math.floor( Math.random() * ( i + 1 ) );
	     var tempi = array[i];
	     var tempj = array[j];
	     array[i] = tempj;
	     array[j] = tempi;
	  }
}