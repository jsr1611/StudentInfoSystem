const tableTemplate = document.createElement("template");
tableTemplate.innerHTML = `
    <thead id="thead">
        <tr>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Nationality</th>
            <th>Gender</th>
            <th>Faculty</th>
            <th>Admission Year</th>
            <th>Level</th>
            <th>Residential Hall</th>
            <th>Supervisor Name</th>
            <th>Research Topic</th>
        </tr>
    </thead>
    <tbody id="tbody">
    </tbody>
`;

const table = document.getElementById("recordsTable");
table.appendChild(tableTemplate.content);


function createEl(tag, p_class, val){
    const el = document.createElement(tag);
    el.classList.add(p_class);
    el.innerText = val;
    return el;
}

function displayIt(records){
    const tbody = document.getElementById("tbody");
    const UGGRAD = "UNDERGRADUATE";
    const PGGRAD = "POSTGRADUATE";
    records.forEach(rec => {
        let tr = document.createElement("tr");
        let resHall = "N/A";
        let supervisor = "N/A";
        let rtopic = "N/A";
        if(rec.level === UGGRAD){
            resHall = rec.residentialHall;
        }
        else if(rec.level === PGGRAD){
            supervisor = rec.supervisorName;
            rtopic = rec.researchTopic;
        }

        tr.appendChild(createEl("th", "th", rec.studentID));
        tr.appendChild(createEl("th", "th", rec.fullName));
        tr.appendChild(createEl("th", "th", rec.nationality));
        tr.appendChild(createEl("th", "th", rec.gender));
        tr.appendChild(createEl("th", "th", rec.faculty));
        tr.appendChild(createEl("th", "th", rec.admissionYear));
        tr.appendChild(createEl("th", "th", rec.level));
        tr.appendChild(createEl("th", "th", resHall));
        tr.appendChild(createEl("th", "th", supervisor));
        tr.appendChild(createEl("th", "th", rtopic));
        tbody.appendChild(tr);
    });

}

function displayMessage(msg, elementId) {
    console.log(elementId);
    let htmlElement = document.querySelector(elementId);
    console.log(htmlElement);
    let par = htmlElement.querySelector("p.msg");
    console.log(par);
    if(par == null ){
        par = createEl("p", "msg", msg);
        htmlElement.appendChild(par);
    }else {
        console.log(par.innerText);
        par.innerText = msg;
    }

}