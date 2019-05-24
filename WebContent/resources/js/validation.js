
function validationForDetail(params)
{
	
	//alert(params[0]);
	var x="."+params[0];
	var count=0;
	var temp_count=0;
	var cnt1=0;
	var cnt2=0;
	$(x).each(function() {cnt1++;
		 //var x=$(this).val();
		 var m= $(this).val() == '' ? 0 : $(this).val();
		 //alert(m);
		 if(m!='0'){
			 		for(var k=1;k<params.length;k++)
			 				{
			 				var temp=$(this).closest("tr").find(params[k]).val() == '' ? 0 : $(this).closest("tr").find(params[k]).val();
			// alert(temp);
			 						if(m!='0' && temp=='0')
			 							{//alert("hii");
			 							$(this).closest("tr").find(params[k]).css("background-color", "yellow"); 
			 							temp_count=parseInt(temp_count)+1;
			 							}
			 
			 				}
		 			}
		 else
			 {
			 cnt2++;
			 }
		 if(parseInt(temp_count)>0)
			 {
			 count++;
			 }
		// alert(sum1);
		});
	if(parseInt(count)>0)
		{
		errors[errors.length] ="Please provide all the required fields";
		
		}
	if(cnt1==cnt2)
		{
		errors[errors.length] ="Please select atleast one item";
		}
	
	}


function Negative(uadd,x)
{
	var val=uadd.value;
	if(val==0 || val<0)
		{
		errors[errors.length] = x+" Cannot be Nagetive Value.";
		}
}

function Zero(uadd,x)
{
	var val=uadd.value;
	if(val==0 || val<0)
		{
		errors[errors.length] = x+" Cannot be 0.";
		}
}

function checkBlank(uadd,x)
{
	var val=uadd.value;
	if(val=="" || val==null)
		{
		errors[errors.length] = x+" Cannot be blank.";
		
		}
	
	}
function checkIsnan(uadd,x)
{
	var val=uadd.value;
	//alert("the is nan is:-"+isNaN(val));
	if(isNaN(val)==true||val=="" || val==null)
		{
		//alert("in if part");
		errors[errors.length] = x+" must be numeric.";
		}

}

function Email(uadd,x)
{
	var val=uadd.value;
	if(val=="" || val==null)
		{
		errors[errors.length] = x+" Email must be filled out.";
		}
	
	}


function Dropdown(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Item Type";
}
}

function Dropdown1(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Associate Type";
}
}
function Dropdown2(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" State";
}
}
function Dropdown3(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Design By";
}
}
function Dropdown4(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Item Type";
}
}
function Dropdown5(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Item ";
}
}
function Dropdown6(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Outlet";
}
}
function Dropdown7(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Rate Type";
}
}

function Dropdown8(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Organization";
}
}
function Dropdown9(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Vender";
}
}
function Dropdown10(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Design";
}
}
function Dropdown11(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" UOM";
}
}
function Dropdown12(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Misc Head";
}
}
function Dropdown13(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Financial Year";
}
}
function Dropdown14(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Design No";
}
}
function Dropdown15(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" UOM";
}
}
function Dropdown16(uadd,x)
{
//alert("for dropdown");
var strUser = uadd.options[uadd.selectedIndex].value;
//if you need text to be compared then use
var strUser1 = uadd.options[uadd.selectedIndex].text;
if(strUser==0) //for text use if(strUser1=="Select")
{
	errors[errors.length] = x+" Karigarh";
}
}



function checkMinus(val,x)
{
	var str=val;
	//alert('1== '+str);
	var i;
	for(i=0;i<str.length;i++)
		{
		var res = str.charAt(i);
		    if(res=='-')
		    {
		    	alert("Minus not allowed here....");
		    	$(x).closest('tr').find('#amount').val('');
		    	//$(x).closest('tr').find('#rate').val('');
		    }	
		}
	
}

			function userid_validation(uid, mx, my)
            {
                var uid_len = uid.value.length;
                if (uid_len == 0 || uid_len >= my || uid_len < mx)
                {
                    alert("User Id should not be empty / length be between " + mx + " to " + my);
                    uid.focus();
                    return false;
                }
                return true;
            }
            function passid_validation(passid, mx, my)
            {
                var passid_len = passid.value.length;
                if (passid_len == 0 || passid_len >= my || passid_len < mx)
                {
                    alert("Password should not be empty / length be between " + mx + " to " + my);
                    passid.focus();
                    return false;
                }
                return true;
            }
            function validationNm(uname)
            {
                var letters =  /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
                if (uname.value.match(letters))
                {
                
                    return true;
                }
                else
                {
                
                    return false;
                }
            }
          
            function validation_Website(str)
            {
                var web =/^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
               if (str.value.match(web))
                {
               
                    return true;
                }
                else
                {
               return false;
                }
            }
            
            function validationAddress(address,x)
            {
                var add = /^[a-zA-Z0-9\s,.'-]{3,}$/;
                if (address.value.match(add))
                {
               
                    //return true;
                }
                else
                {
                	errors[errors.length] = x+" Field Must not be Empty.";
               //return false;
                }
            }
            function alphanumeric(uadd,x)
            {
                var letters = /^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/;
                if (uadd.value.match(letters))
                {
                    //return true;
                }
                else
                {
                	 errors[errors.length] = x+" Field Must not be Empty.";
                    //return false;
                }
            }
              function allnumeric(id,x)
            {
                var letters = /^[0-9]+$/;
                if (id.value.match(letters))
                {
                	alert(hiooo);
                    //return true;
                }
                else
                {
                	//alert(heyyyy);
                 errors[errors.length] = x+" Field Must not be Empty."; 
                   // return false;
                }
            }
              
//              function allnumeric(itmTyp)
//              {
//                  var letters = /^[0-9]+$/;
//                  if (itmTyp.value.match(letters))
//                  {
//                      return true;
//                  }
//                  else
//                  {
////                    
//                      return false;
//                  }
//              }
            function countryselect(ucountry)
            {
                if (ucountry.value == "Default")
                {
                    alert('Select your country from the list');
                    ucountry.focus();
                    return false;
                }
                else
                {
                    return true;
                }
            }
            function ZIP(uzip)
            {
                var numbers = /^[0-9]+$/;
                if (uzip.value.match(numbers))
                {
                    return true;
                }
                else
                {

                    return false;
                }
            }
            
           function PHONE_NO(uphone)
            {
                var numbers = /^\d{10}$/;
                if (uphone.value.match(numbers))
                {
                    return true;
                }
                else
                {

                    return false;
                }
            }
              function FAX(fax)
            {
                var numbers = /^\d{10}$/;
                if (fax.value.match(numbers))
                {
                    return true;
                }
                else
                {

                    return false;
                }
            }
//            function validation_Email(email)
//            {
//                var mailformat =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//                if (email.value.match(mailformat))
//                {
//                    return true;
//                }
//                else
//                {
//                
//                    return false;
//                }
//            }
            
              function ValidateDate(compDate)
            {
                var date_formate =/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
                if (compDate.value.match(date_formate))
                {
                    return true;
                }
                else
                {
              
                    return false;
                }
            }
            function getDay()
              {
                var sd=document.getElementById("date1").value;
                var ed=document.getElementById("date2").value;
                // alert(sd+ed);
                var startDate = new Date(sd);
                var endDate = new Date(ed);
                var totalSundays = 0;
                var totalSaturday=0;
                var weekDays=0;
                var workingHrs=0;
                for (var i = startDate; i <= endDate; ){
                    if (i.getDay() == 0){
                        totalSundays++;
                    }
                    else if(i.getDay()==6){
                        totalSaturday++; 
                    }
                    else{
                        weekDays++;
                    }
                    i.setTime(i.getTime() + 1000*60*60*24);
                    }
                    //alert("Sun:"+totalSundays +"Sat:"+ totalSaturday +"Week:"+ weekDays );
                    workingHrs=(totalSundays*0)+(totalSaturday*4)+(weekDays*8);
                    //alert(workingHrs);
                    document.getElementById("wHRS").value=workingHrs;
              }
            function ValidateAmount(uamount)
            {



                if (uamount.value.match(amount))
                {
                    return true;
                }
                else
                {
                    alert("an invalid amount");
                    return false;
                }
            }

            function validsex(umsex, ufsex)
            {
                x = 0;

                if (umsex.checked)
                {
                    x++;
                }
                if (ufsex.checked)
                {
                    x++;
                }

                if (x == 2)
                {
                    alert('Both Male/Female are checked');
                    ufsex.checked = false
                    umsex.checked = false
                    umsex.focus();
                    return false;
                }

                if (x == 0)
                {
                    alert('Select Male/Female');
                    umsex.focus();
                    return false;
                }
                else
                {
                    alert('Form Succesfully Submitted');
                    window.location.reload()
                    return true;
                }
//  function validationNm(uname){
//                
//  if (x==null || x=="")
//  {
//  alert("Category must be filled out");
//  return false;
//  }
//                }
               
            }
            function finalCheck()
            {
            	//alert("hissssssssssssssssssssss");
                if (errors.length > 0) {
                    var err = "";
                    for (var i = 0; i < errors.length; i++)
                    {
                        err = err +  errors[i] + '\n';
                    }
                    alert(err);
                    return false;
                }
                else
                {
                    return true;
                }
            }
            
   //arnab
          
        