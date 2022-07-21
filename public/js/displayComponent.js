const template = document.createElement("template");
template.innerHTML = `
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

const table = document.getElementById("table");
table.appendChild(template.content);


function createEl(tag, val){
    const el = document.createElement(tag);
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

        tr.appendChild(createEl("th", rec.studentID));
        tr.appendChild(createEl("th", rec.fullName));
        tr.appendChild(createEl("th", rec.nationality));
        tr.appendChild(createEl("th", rec.gender));
        tr.appendChild(createEl("th", rec.faculty));
        tr.appendChild(createEl("th", rec.admissionYear));
        tr.appendChild(createEl("th", rec.level));
        tr.appendChild(createEl("th", resHall));
        tr.appendChild(createEl("th", supervisor));
        tr.appendChild(createEl("th", rtopic));
        tbody.appendChild(tr);
    });

}

function displayMessage(msg) {
    let par = createEl("p", msg);
    let msgEl = document.getElementById("message");
    msgEl.appendChild(par);
}