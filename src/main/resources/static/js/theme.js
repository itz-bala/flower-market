const body = document.body;

if(localStorage.getItem("theme")=="dark"){
    body.classList.add("dark-mode");
}

function toggleTheme(){

    body.classList.toggle("dark-mode");

    if(body.classList.contains("dark-mode")){
        localStorage.setItem("theme","dark");
    }else{
        localStorage.setItem("theme","light");
    }

}