//JavaScript Document

var arrOptions = new Array();

var strLastValue = "";

var theTextBox;

var currentValueSelected = -1;

var req;


window.onload = function()
{
	var elemSpan = document.createElement("span");
	elemSpan.id = "spanOutput";
	elemSpan.className = "spanTextDropdown";
        theTextBox = document.auto.txtUserInput;
	document.body.appendChild(elemSpan);
	document.auto.txtUserInput.onkeyup = GiveOptions;
}

function GiveOptions()
{
	var intKey = -1;
	if(window.event)
	{
		intKey = event.keyCode;
		theTextBox = event.srcElement;
	}

	if(theTextBox.value.length == 0)
	{
		HideTheBox();
		strLastValue = "";
		return false;
	}

	if(intKey == 13)
	{
		GrabHighlighted();
		theTextBox.blur();
		return false;
	}else if(intKey == 38){
		MoveHighlight(-1);
		return false;
	}else if(intKey == 40){
		MoveHighlight(1);
		return false;
	}


	if( theTextBox.value.indexOf(strLastValue) !=0  || arrOptions.length == 0 ||
		(strLastValue.lenght == 0 && theTextBox.value.length > 0) ||
		(theTextBox.value.length <= strLastValue.length) ){
			strLastValue = theTextBox.value;
			TypeAhead(theTextBox.value);
		}else
		{
			BuildList(theTextBox.value);
		}
}



function TypeAhead(xStrText)
{
	var url = "make?param=" + xStrText;
	if(window.XMLHttpRequest){
          req = new XMLHttpRequest();
	}else if(window.ActiveXObject){
          try {
                req = new ActiveXObject("Msxml2.XMLHTTP");
            }catch (e){
                try {
                    req = new ActiveXObject("Microsoft.XMLHTTP");
                }catch (e) {}
            }
	}

	if(req){
		req.open("GET", url, true);
		req.onreadystatechange=callback;
		req.send(null);
	}
}


function callback()
{
	if(req.readyState == 4){
		if(req.status == 200){
			parseMessage();
		}else{
			alert("Not able to retrieve description " + req.statusText);
		}
	}else
	{

	}
}



function parseMessage()
{
        var xmlDoc = req.responseXML.documentElement;
        var node = xmlDoc.getElementsByTagName('info');

        arrOptions = new Array();
	for(var i=0; i < node.length; i++)
	{
		arrOptions[i] = node[i].firstChild.nodeValue;
	}
	BuildList(theTextBox.value);
	strLastValue = theTextBox.value;
}


function BuildList(theText)
{
	SetElementPosition();
	var inner = "";
	var theMatches = MakeMatches(theText);
	for(var i = 0 ; i < theMatches.length ; i++)
	{
		inner += theMatches[i];
	}

	if(theMatches.length > 0)
	{
		document.getElementById("spanOutput").innerHTML = inner;
		document.getElementById("OptionsList_0").className = "spanHighElement";
		currentValueSelected = 0;
	}else{
		HideTheBox();
	}

}


function SetElementPosition()
{
	var selectedPosX = 0;
	var selectedPosY = 0;
	var theElement = document.auto.txtUserInput;
	var theTextBoxInt = document.auto.txtUserInput;
	if(!theElement) return;
	var theElementHeight = theElement.offsetHeight;
	var theElementWidth = theElement.offsetWidth;
	while(theElement != null){
		selectedPosX += theElement.offsetLeft;
		selectedPosY += theElement.offsetTop;
		theElement = theElement.offsetParent;
	}

	xPosElement = document.getElementById("spanOutput");
	xPosElement.style.left = selectedPosX;
	xPosElement.style.width = theElementWidth;
	xPosElement.style.top = selectedPosY + theElementHeight;
	xPosElement.style.display = "block";
}


var countForId = 0;


function MakeMatches(xCompareStr)
{
	countForId = 0;
	var matchArray = new Array();
	var regExp = new RegExp(xCompareStr,"ig");
	for(var i=0 ; i < arrOptions.length ; i++)
	{
		if(arrOptions[i].search(regExp) >= 0 )
		{
			matchArray[matchArray.length] = CreateUnderline(arrOptions[i],xCompareStr,i);
		}
		else
		{
			continue;
		}
	}

	return matchArray;
}



var undeStart = "<span class='spanMatchText'>";
var undeEnd  = "</span>";

var selectSpanStart = "<span style='width:100%;display:block;' class='spanNormalElement' onMouseover='SetHighColor(this)' ";
var selectSpanEnd = "</span>";

function CreateUnderline(xStr,xTextMatch,xVal)
{
	selectSpanMid = "onclick='SetText("+ xVal +")'" + " id='OptionsList_" + countForId + "' theArrayNumber='"+ xVal +"'>";
	countForId++;
	var regExp = new RegExp(xTextMatch,"ig");
	var start = xStr.search(regExp);
	var matchedText = xStr.substring(start,start + xTextMatch.length);
	var Replacestr = xStr.replace(regExp,undeStart + matchedText + undeEnd);

	return selectSpanStart + selectSpanMid + Replacestr + selectSpanEnd;
}


function SetHighColor(theTextBox)
{
	if(theTextBox)
	{
		currentValueSelected = theTextBox.id.slice(theTextBox.id.indexOf("_") + 1,theTextBox.id.length);
	}

	for(var i = 0 ; i<countForId ; i++)
	{
		document.getElementById('optionsList_' + i).className = 'spanNormalElement';
	}
	document.getElementById('OptionsList_' + currentValueSelected).className = 'spanHighElement';
}


function SetText(xVal)
{
	theTextBox = document.auto.txtUserInput;
	theTextBox.value = arrOptions[xVal];
	document.getElementById("spanOutput").style.display = "none";
	currentValueSelected = -1;
}

function GrabHighlighted()
{
	if(currentValueSelected >=0 )
	{
		xVal = document.getElementById("OptionsList_" + currentValueSelected).getAttribute("theArrayNumber");
		SetText(xVal);
		HideTheBox();
	}
}


function HideTheBox()
{
	document.getElementById("spanOutput").style.display = "none";
	currentValueSelected = -1;
}


function MoveHighlight(xDir)
{
	if(currentValueSelected >= 0)
	{
		newValue = parseInt(currentValueSelected) + parseInt(xDir);
		if(newValue > -1 && newValue < countForId)
		{
			currentValueSelected = newValue;
			SetHighColor(null);
		}

	}
}

function ReDraw()
{
	BuildList(document.auto.txtUserInput.value);
}
















