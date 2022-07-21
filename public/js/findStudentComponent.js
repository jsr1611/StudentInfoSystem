function createTemplate(containerId, elementId, title) {
    const template = document.createElement("template");
    template.innerHTML = `
        <div id="${elementId}">
            <h3>${title}</h3>
            <form id="findForm">
                <div>
                    <p>Student ID</p>
                    <input type="number" id="studentID" placeholder="Enter student ID">
                </div>
                <br>
                <div>
                    <button id="findBtn">Find</button>
                    <button id="returnHomeBtn">Return Home</button>
                </div>
        
            </form>
            <br>
            <div class="message">
            </div>
        </div>
        `;


    return template;
}