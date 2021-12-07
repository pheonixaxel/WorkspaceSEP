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
    for(let i=0;i<days.length;i++)
    {
        table+="<tr><td class='scheduleHead'>Monday</td>";
        let lessons = days[i].getElementsByTagName("lesson");
        for(let j=0;j<lessons.length;j++)
        {
            table+="<td class='scheduleCell'>"+
            lessons[j].getElementsByTagName("beginTime")[0].childNodes[0].nodeValue+"-"+
            lessons[j].getElementsByTagName("endTime")[0].childNodes[0].nodeValue+"<br>"+
            lessons[j].getElementsByTagName("id")[0].childNodes[0].nodeValue+", "+
            lessons[j].getElementsByTagName("teacher")[0].childNodes[0].nodeValue+"<br>"+
            lessons[j].getElementsByTagName("room")[0].childNodes[0].nodeValue+"</td>";
        }
        table+="</tr>";
    }
    document.getElementById("scheduleTable").innerHTML=table;
}

readXML();