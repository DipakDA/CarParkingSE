"use strict";

//Basic server hosting script.

let express = require("express");
let app = express();
let port = process.env.PORT || 3000;

app.get('/', createServ);
function createServ(req, res){
  console.log("Server started");
  res.write("Server Started");
  res.end();
}

app.listen(port, function() {
  console.log("Server started");
});
