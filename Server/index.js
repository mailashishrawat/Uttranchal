var express = require("express");
//var cors = require("cors");
var path = require("path");
//var bodyParser = require("body-parser");


var app = new express();

/*simple hello world 
app.get('/', function (req, res) {
    res.send('Hello World');
 })
*/ 
 
app.use(express.static('.././public_html')); 
//app.use('/static', express.static(path.join(__dirname,'../app/dist/static')));
/*app.get('/', function (req, res) {
    console.log('root:' + req.url);
    var filepath = path.join(__dirname, "../app/dist/index.html")
    console.log(filepath);
    res.redirect(filepath);
});
app.get('/static/img/logo.8633eae.png', function (req, res) {
    console.log("Static" + req.url);
    var filepath = path.join(__dirname, "../app/dist/static", req.url);
    console.log(filepath);
    res.redirect(filepath);
   // res.send(filepath);
})
app.get('/static/(.*)', function (req, res) {
    console.log("Static" + req.url);
    var filepath = path.join(__dirname, "../app/dist", req.url);
    console.log(filepath);
    res.redirect(filepath);
//res.send("filepath");
});*/
/*app.use(bodyParser.urlencoded({
    extended: false
}));
*/
/*app.ws('/echo', function (ws, req) {
    ws.on('message', function (msg) {
        console.log("onmessage called");
        console.log(msg);
        ws.send(msg);
    });
});*/
app.get('/', function (req, res) {
    var filepath = path.join(__dirname, ".././public_html/index.html");
    
    console.log(filepath);
    res.sendFile(filepath);
});
var server=app.listen(3000, function () {
    console.log("server started sucessfully");
    var host = server.address().address
    var port = server.address().port
    
    console.log("Example app listening at http://%s:%s", host, port)
});