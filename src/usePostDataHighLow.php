<?php
//array関数でトランプの画像名を配列で作成
$cards=array("Jk.png","01.png","02.png","03.png","04.png","05.png","06.png","07.png","08.png","09.png","10.png","11.png","12.png","13.png");
//POST送信データを変数に代入
$Lnum=$_POST['lnum'];
$Rnum=$_POST['rnum'];
$Mondai=$_POST['mondai']
?>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	</head>
	<body style="text-align:center;">
	<?php
	echo"<span style='font-size:28px;'>High＆Lowゲーム<br></span>";
	print"<hr>";
	echo'<img src="../cards/',$cards[$Lnum],'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	echo'<img src="../cards/',$cards[$Rnum],'"><br><br>';
	
	if(($Lnum>$Rnum&&$Mondai=="High")||($Lnum<$Rnum&&$Mondai=="Low")){
	    echo$Mondai,'を選択しました。<br><br>';
        echo'You Lose...<br><br>';
	    }
        else{
            echo$Mondai,'を選択しました。<br><br>';
            echo'You Win!<br><br>';
        }
	?>
	<a href="highLow.php">もう一度挑戦</a>
	</body>
</html>