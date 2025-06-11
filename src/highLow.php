<?php
	//array関数でトランプの画像名を配列で作成
	$cards=array("Jk.png","01.png","02.png","03.png","04.png","05.png","06.png","07.png","08.png","09.png","10.png","11.png","12.png","13.png");
	//0-13の範囲でランダム数値を取得
	$num1=mt_rand(0,13);
	$num2=mt_rand(0,13);
?>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	</head>
	<body style="text-align:center;">
	<form action="usePostDataHighLow.php"method="post">
	<?php
	echo"<span style='font-size:28px;'>High＆Lowゲーム<br></span>";
	print"<hr>";
	echo'<img src="../cards/',$cards[$num1],'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	echo'<img src="../cards/bg.png"><br>';
	?>
	<input type="radio" name="mondai" value="High">High&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="radio" name="mondai" value="Low">Low <br><br>
	<?php
	echo'<input type="hidden" name="lnum" value="',$num1,'">';
	echo'<input type="hidden" name="rnum" value="',$num2,'">';
	?>
	<input type="submit" value="決定">
	</form>
	</body>
</html>