function readXML(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            showData(this);
        }
    };
    xhttp.open("GET","xml/schedule.xml",true);
    xhttp.send();
}

function showData(xml){
    let xmlDoc = xml.responseXML;
    let table = "";
    let days = xmlDoc.getElementsByTagName("day");
    let array = [];
    array[0]="<tr><td class='scheduleHead'>Monday</td><td class='scheduleHead'>Tuesday</td><td class='scheduleHead'>Wednesday</td><td class='scheduleHead'>Thursday</td><td class='scheduleHead'>Friday</td></tr>"
    for(let i=0;i<days.length;i++)
    {
        let lessons = days[i].getElementsByTagName("lesson");
        for(let j=0;j<lessons.length;j++)
        {
            if(i==0)array[j+1]="<tr>";
            array[j+1]+="<td class='scheduleCell'>"+
            lessons[j].getElementsByTagName("beginTime")[0].childNodes[0].nodeValue+"-"+
            lessons[j].getElementsByTagName("endTime")[0].childNodes[0].nodeValue+"<br>"+
            lessons[j].getElementsByTagName("id")[0].childNodes[0].nodeValue+", "+
            lessons[j].getElementsByTagName("teacher")[0].childNodes[0].nodeValue+"<br>"+
            lessons[j].getElementsByTagName("room")[0].childNodes[0].nodeValue+"</td>";
            if(i==days.length-1)array[j+1]+="</tr>";
        }
    }
    for(let i=0;i<array.length;i++)
    {
        console.log(array[i]);
        table+=array[i];
    }
    document.getElementById("scheduleTable").innerHTML=table;
}

readXML();