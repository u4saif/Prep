console.log("app script started.");

const searchInput = document.getElementById("search");
const clickButton = document.getElementById("clickBtn");

if (searchInput) {
    searchInput.addEventListener("keydown", myDebounce((e) => {
        console.log(e);
    }, 2000));
}

function myDebounce(cb,time){ 
    let timeCounterId;
     
     return function(...args){
        if (timeCounterId) {
            clearTimeout(timeCounterId);
        }

        timeCounterId = setTimeout(() => {
            cb(...args);
        }, time);
    }
}


// if (clickButton) {
//   clickButton.addEventListener("click", () => {
//     console.log("Button clicked");
//   });
// }
