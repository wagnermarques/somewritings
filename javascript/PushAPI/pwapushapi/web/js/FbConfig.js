const firebaseConfig = null;
let response = await fetch("FbConfig.php");
if (response.ok) { // if HTTP-status is 200-299
  let fbConfigJsonFormat = await response.json();
  firebaseConfig = destr(fbConfigJsonFormat);
} else {
  alert("HTTP-Error: " + response.status);
}
