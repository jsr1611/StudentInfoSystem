function createTemplate(containerId, elementId, title) {
    const template = document.createElement("template");
    template.innerHTML = `
        <div id="${elementId}">
            <h3 id="findOrRemoveTitle">${title}</h3>
            <form id="findForm">
                <div>
                    <p><i class="fa-solid fa-id-badge"></i>Student ID</p>
                    <input type="number" id="studentID" placeholder="Enter student ID">
                </div>
                <br>
                <div class="findBtns">
                    <button id="findBtn"><i class="fa-solid fa-magnifying-glass"></i>Find</button>
                    <button id="returnHomeBtn"><i class="fa-solid fa-house"></i>Return Home</button>
                    <button id="multi-button"><i class="fa-solid fa-trash-can"></i>Delete</button>
                </div>
        
            </form>
            <br>
            <div class="message">
            </div>
        </div>
        `;


    return template;
}