import { setLayout } from "./utils/render.js";
import {Router} from "./Components/Router.js";

const HEADER_TITLE = "Sacho Antiques";
const PAGE_TITLE = "Sacho Antiques"
const FOOTER_TEXT = "Développé dans le cadre du cours de PAE par Obey, Yvan, Nicola, Emil et Julien \n Contact ";


Router();

setLayout(HEADER_TITLE, PAGE_TITLE, FOOTER_TEXT);
