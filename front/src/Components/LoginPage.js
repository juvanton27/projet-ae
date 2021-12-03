/* In a template literal, the ` (backtick), \ (backslash), and $ (dollar sign) characters should be 
escaped using the escape character \ if they are to be included in their template value. 
By default, all escape sequences in a template literal are ignored.*/
import { getUserSessionData, setUserSessionData } from "../utils/session.js";
import { RedirectUrl } from "./Router.js";
import callAPI from "../utils/api.js";
const API_BASE_URL = "/api/auths/";


let loginPage = `
<div class="container mt-5 ">
  <div class="wrapper fadeInDown">
    <div id="formContent navBar_colors">
    <div class="fadeIn first mt-3">
      <h3>Connexion</h3>
    </div>
        <form>
        <div class="form-group mt-3 fadeIn second">
          <p>Email</p>
          <input class="form-control" id="login" type="text" name="login" placeholder="Entrez votre login" required=""/>
        </div>
        <div class="form-group fadeIn third">
          <p><label for="password">Password</label></p>
          <input class="form-control" id="password" type="password" name="password" placeholder="Enter votre mot de passe" required="" />
        </div>
        <div class="alert alert-danger m-2 d-none" id="messageBoard"></div>
        <button class="btn btn-primary mt-2 fadeIn third" id="btn" type="submit">Se connecter</button>
        <!-- Create an alert component with bootstrap that is not displayed by default-->
        
        </form>
        <br>

    </div>
  </div>
</div>
`;

const LoginPage = () => {  
  let page = document.querySelector("#page");
  page.innerHTML = loginPage;
  let loginForm = document.querySelector("form");
  const user = getUserSessionData();
  if (user) {
    // re-render the navbar for the authenticated user
    Navbar();
    RedirectUrl("/accueil");
  } else loginForm.addEventListener("submit", onLogin);
};

const onLogin = async (e) => {
  e.preventDefault();
  let login = document.getElementById("login");
  let password = document.getElementById("password");

  let user = {
    login: login.value,
    password: password.value,
  };

  try {
    const userLogged = await callAPI(
      API_BASE_URL + "login",
      "POST",
      undefined,
      user
    );
    onUserLogin(userLogged);
  } catch (err) {
    console.error("LoginPage::onLogin", err);
  }
};

const onUserLogin = (userData) => {
  console.log("onUserLogin:", userData);
  const user = { ...userData, isAutenticated: true };
  setUserSessionData(user);
  // re-render the navbar for the authenticated user
  Navbar();
  RedirectUrl("/films");
};

export default LoginPage;
