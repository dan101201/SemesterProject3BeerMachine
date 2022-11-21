<?php require_once("http://localhost:8087/JavaBridge/java/Java.inc");

$System = java("java.lang.System");
echo $System->getProperties();

$world = new java("Domain.PHPConnection");
var_export($world->hello(array("from PHP")));
?>