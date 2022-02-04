<?php
$arr = array(
    "apiKey" => getenv("apiKey"),
    "authDomain" => getenv("authDomain"),
    "databaseURL" => getenv("databaseURL"),
    "projectId" => getenv("projectId"),
    "storageBucket" => getenv("storageBucket"),
    "messagingSenderId" => getenv("messagingSenderId"),
    "appId" => getenv("appId"),
    );
echo json_encode($arr);
