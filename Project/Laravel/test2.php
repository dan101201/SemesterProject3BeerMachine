<?php
require 'vendor/autoload.php';

$client = new GuzzleHttp\Client([
    'base_uri' => 'http://localhost:4567/'
]);

//GET test
$res = $client->get('/hello', [
    //'auth' =>  ['user', 'pass']
]);
//echo $res->getStatusCode();           // 200
//echo $res->getHeader('content-type'); // 'application/json; charset=utf8'
//echo $res->getBody();                 // {"type":"User"...'
var_export($res->getBody().json_decode($res->getBody()));    // Outputs the JSON decoded data

//POST test
$res = $client->request('POST', '/hello', [
    'json' => ['foo' => 'bar']
]);
var_export($res->getStatusCode());    // Outputs the JSON decoded data
?>