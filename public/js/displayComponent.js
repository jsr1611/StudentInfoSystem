const tableTemplate = document.createElement("template");
tableTemplate.innerHTML = `
    <thead id="thead">
        <tr>
            <th><i class="fa-solid fa-id-badge"></i>Student ID</th>
            <th><i class="fa-solid fa-pen-nib"></i>Full Name</th>
            <th><i class="fa-solid fa-globe"></i>Nationality</th>
            <th><i class="fa-solid fa-mars-and-venus"></i>Gender</th>
            <th><i class="fa-solid fa-school"></i>Faculty</th>
            <th><i class="fa-solid fa-calendar-check"></i>Admission Year</th>
            <th><i class="fa-solid fa-user-graduate"></i>Level</th>
            <th><i class="fa-solid fa-location-dot"></i>Residential Hall</th>
            <th><i class="fa-solid fa-chalkboard-user"></i>Supervisor Name</th>
            <th><i class="fa-solid fa-book-open"></i>Research Topic</th>
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

function clearTable(){
    let tbody = recordsTable.querySelector("tbody");
    if(recordsTable.rows.length > 1){
        tbody.innerHTML = "";
    }
    let err_el = document.querySelector(".msg");
    if(err_el != null){
        err_el.innerHTML = "";
        err_el = err_el.parentNode;
        err_el.classList.remove("error-msg");
    }
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
    let htmlElement = document.querySelector(elementId);
    htmlElement.classList.add("error-msg");
    let par = htmlElement.querySelector("p.msg");
    if(par == null ){
        par = createEl("p", "msg", msg);
        htmlElement.appendChild(par);
    }else {
        par.innerText = msg;
    }

}