function getMsDetailsByName(){
var empIdStr = document.getElementById("msname").value

var url = new URL("https://microservices-details.cfapps.io/microservice/details/name?msname=samplems")
url.searchParams.set('msname', empIdStr)
console.log(url)

	// Create a request variable and assign a new XMLHttpRequest object to it.
var request = new XMLHttpRequest();

// Open a new connection, using the GET request on the URL endpoint
request.open('GET', url, true);

request.onload = function () {
  // Begin accessing JSON data here
	var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
   
		console.log(data.name);
		document.getElementById("name").innerHTML= String(data.name)
		document.getElementById("type").innerHTML=String(data.type)
        document.getElementById("description").innerHTML=String(data.description)
        showTuxedoCalls(data)
        showPaths(data)
        showMethods(data)
	
  } else {
    console.log('error');
  }
  
  }


// Send request
request.send();


}

function showTuxedoCalls(jsonObj){
    var tuxedoCalls = jsonObj['tuxedoCalls'];
    var myList = document.createElement('ul');
    var para = document.createElement('p');
    para.innerHTML = 'Tuxedo Calls : ';

    for (var j = 0; j < tuxedoCalls.length; j++) {
        var listItem = document.createElement('li');
        listItem.innerHTML = tuxedoCalls[j];
        myList.appendChild(listItem);
      }

     
     document.getElementsByTagName('body')[0].appendChild(para)
     document.getElementsByTagName('body')[0].appendChild(myList)
}



function showPaths(jsonObj){
    var paths = jsonObj['paths'];
    var myList = document.createElement('ul');
    var para = document.createElement('p');
    para.innerHTML = 'Paths : '

    for (var j = 0; j < paths.length; j++) {
        var listItem = document.createElement('li');
        listItem.innerHTML = paths[j];
        myList.appendChild(listItem);
      }

     
     document.getElementsByTagName('body')[0].appendChild(para)
     document.getElementsByTagName('body')[0].appendChild(myList)
}

function showMethods(jsonObj){
    var methods = jsonObj['methods'];
    var myList = document.createElement('ul');
    var para = document.createElement('p');
    para.innerHTML = 'Methods : '

    for (var j = 0; j < methods.length; j++) {
        var listItem = document.createElement('li');
        listItem.innerHTML = methods[j];
        myList.appendChild(listItem);
      }

     
     document.getElementsByTagName('body')[0].appendChild(para)
     document.getElementsByTagName('body')[0].appendChild(myList)
}