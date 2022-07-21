window.GoHome = function GoHome(event){
    let linkHome = ""
    if(window.location.href.includes("/public")){
        linkHome = "../../index.html";
    }else{
        linkHome = "./index.html";
    }
    clickLink(linkHome);
}



window.clickLink = function clickLink(link){
    const el = document.createElement("a");
    el.href = link;
    el.click();
}
