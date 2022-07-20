const header = document.createElement("template");
header.innerHTML = `
<h2 id="home">Student Information System</h2>
<button id="exit">Exit</button>
<div id="menu">
    <button id="add">Add</button>
    <button id="remove">Remove</button>
    <button id="find">Find</button>
    <button id="display">Display All</button>
</div>
<h3 id="resultHeader">Result</h3>
<hr>
`;
document.body.appendChild(header.content);
const btnExit = document.getElementById("exit");
const home = document.getElementById("home");

const add = document.getElementById("add");
const remove = document.getElementById("remove");
const find = document.getElementById("find");
const display = document.getElementById("display");

function createLink(link){
    const el = document.createElement("a");
    el.href = link;
    el.click();
}



function GoHome(event){
    let linkHome = ""
    if(window.location.href.includes("/public")){
        linkHome = "../../index.html";
    }else{
        linkHome = "./index.html";
    }
    createLink(linkHome);
}

function handleExit(event){
    let response = confirm("Do you really want to exit the application?");
    if(response){
        window.close();
    }
}

function displayAll(event){
    console.log("I am here");
    let linkDisplay = ""
    if(window.location.href.includes("/public")){
        linkDisplay = "./displayAll.html";
    }else{
        linkDisplay = "./public/pages/displayAll.html";
    }
    createLink(linkDisplay);
}

function addStudent(event){
    console.log("Going to add new student!");
    let linkAdd = "";
    if(window.location.href.includes("/public")){
        linkAdd = "./addStudent.html";
    }else{
        linkAdd = "./public/pages/addStudent.html";
    }
    createLink(linkAdd);
}

function removeStudent(event){
    console.log("Going to remove a student!");
    let linkRemove = "";
    if(window.location.href.includes("/public")){
        linkRemove = "./removeStudent.html";
    }else{
        linkRemove = "./public/pages/removeStudent.html";
    }
    createLink(linkRemove);
}


function findStudent(event){
    console.log("Going to find a student!");
    let linkFind = "";
    if(window.location.href.includes("/public")){
        linkFind = "./findStudent.html";
    }else{
        linkFind = "./public/pages/findStudent.html";
    }
    createLink(linkFind);
}

home.addEventListener("click", GoHome);
btnExit.addEventListener("click", handleExit);
display.addEventListener("click", displayAll);
add.addEventListener("click", addStudent);
remove.addEventListener("click", removeStudent);
find.addEventListener("click", findStudent);
