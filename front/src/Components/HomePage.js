import {getUserSessionData} from "../utils/session.js";

const HomePage = () => {
    document.querySelector("#page_home").classList.remove('full-size');
    let page = document.querySelector("#page");
    let user = getUserSessionData();  
    let accueilPage;
    if (user) {
        accueilPage =`<div class="container">
        <div class="row mt-3">
    
            <div class="col m-4">
            <h1 class="ml10 accueilPage_text">
            <span class="text-wrapper">
            <span class="letters"><p>Vous êtes connectés</p></span>
            </span>
            </h1>            
            </div>
            </div>
    </div>`}else{
        accueilPage=`<div class="container">
        <div class="row mt-3">
    
            <div class="col m-4">
            <h1 class="ml10 accueilPage_text">
            <span class="text-wrapper">
            <span class="letters"><p>Vous n'êtes pas connectés</p></span>
            </span>
            </h1>            
            </div>
            </div>
    </div>`;

    }
 
    page.innerHTML = accueilPage;
}

export default HomePage;