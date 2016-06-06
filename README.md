# Software Studio Assignment 6
103062333 林詠清
103062334 楊炫恭
## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
	本次assignment我import 了 Ani.jar   controlIP5.jar    core.jar 三個 library


## Explanation of the Design
	在這次的assignment中我主要只有實作2個class, 
	一個是Character 裡面是放入.json裡面的每一個物件的基本資料
	另一個是MainApplet 裡面有network實作,動畫實作,按鍵以及滑鼠事件實作
	1.解釋如何將物件移動到右邊並且接上network:
		我們以一個integer陣列 inside[]記下每個物件的狀態
		若第i個物件被移動到右邊  則我們將 inside[i] = 1 
		因次當第i個物件被移動到右邊時 則inside[i] = 1
		 我們會跑.json中所有有關Links的陣列
		若讀取到links中的source 為 i 時   , 我們便將該links中的target也記下來
		此時若 inside[target] = 1 代表該target也在右邊大圓圈上 此時在抓下links中的value值當作兩個links的粗細
		再將兩個物件位置座標記下來 並畫線即可
	2.解釋如何拖拉物件:
		我們的做法是 當滑鼠按下去時 會記下此時的滑鼠座標 並且將所有物件以for迴圈跑過一次
		若滑鼠座標與物件圓心座標小於該物件半徑時 便可以知道滑鼠按下去是按在物件上
		此時將該物件的enable=1  即代表該物件有滑鼠按著
		此時  新增一個 public void mouseDragged()
		此function裡面判斷 當某物件enable = 1 時 , 該物件的xy座標會跟滑鼠座標一樣
		即可完成拖拉物件
	3.解釋放入右邊圓圈以及右邊圓圈顯示物件方法
		為偵測滑鼠放開 我們新設一個function 為 public void mouseReleased()
		此function判斷 當放下滑鼠時  的滑鼠xy座標  與右邊大圓圈的圓心座標小於半徑時
		即代表 該物件已經被移動到右邊的大圓圈
		此時設一變數為numOfcircle 表示右邊圓圈有幾個物件
		再將360/numOfcircle 表示每個物件要相隔幾個角度
		接著利用sin以及cos乘上大圓圈半徑 便可以準確的將右邊的物件以評分角度的方式顯示在大圓圈的周長上(即正多邊形)
	4.解釋如何一次將所有物件放入右邊圈中:
		依照上述第三點以及第一點概念
		此時只要將所有物件的inside[i]=1
		並且再讓numOfcircle = 物件總數
		即可讓右邊的大圓圈也以正多邊形的方式顯示所有物件
	5.解釋如何將物件放回原來位置:
		因為上述滑鼠拖拉的實作  我們會將現在正在拖拉的物件是第幾個物件記下來(假設是第i個)
		又我們左邊顯示物件的方式為 , 一列有10個 ,當一列超過10個時換新的一列
		且左邊每個物件相距60, 最左上的物件座標為30,30,
		因此我們可以將i/10知道該物件在第幾列
		且i%10知道物件在第幾行  
		再用等差級數公式便可以將物件放回原本的位置	
	6. 解釋如何一次將右邊所有物件重新移動到左邊:
		依照第5點概念  此時只要利用一個for迴圈跑所有的物件
		並且每個物件都做上述第5點的事情
		便可以將所有物件移動到左邊
	7.解釋按下數字按鈕會換不同的episodes
		為偵測按下按鈕 我們有public void keyPressed(KeyEvent e)
		當按下不同的數字1~7時
		讀取檔案的String file會依照不同episode改變
		接著在loadData重新讀取檔案即可變換episodes	
	8.解釋動畫:
		在每次移動回去的過程中都會有動畫
		我們利用
		Ani.to(characters.get(i),(float)1.5,"x",posx);
		Ani.to(characters.get(i),(float)1.5,"y",posy);
		可以將此物件以動畫的形式慢慢移動到posx,posy 即我們想要的位置
	9.當滑鼠有移動到物件上方時 會顯示物件的名稱
		為偵測滑鼠移動 我們有public void mouseMoved()
		記下每一次滑鼠移動的滑鼠xy座標值
		並在用一for迴圈跑完所有的物件 若該物件與滑鼠座標距離小於物件半徑時 則顯示出該物件名稱
		
### Operation

本次assignment有實作的內容
	1. 按下按鈕 add all時可以將左半邊所有的物件全部加入右邊大圈圈中
		並且再大圈圈中顯示物件是以正多邊形的方式顯示
	2. 按下按鈕clear all 可以將右半邊大圓球上的所有物件全部移到左邊
		並且是移動到自己原本的位置
		並且每個物件移動回去的時候都會有動畫  , 是緩慢移動回去的
	3. 使用者可以用滑鼠拖拉的方式  將在左邊的物件拉到右邊 
		當物件放入到右邊大球的範圍以內之後 再放開  物件會自動在球的周長上找到屬於自己的位置
		在右邊大球上顯示的物件  有幾個物件就以正幾邊形來排列物件
	4. 使用者可以用滑鼠拖拉的方式   將原本在右邊的物件  拉離圓圈
		只要將物件拉離開原周長
		物件便可以以動畫的方式回到自己原本的位置
	5. 不管任何時候  只要滑鼠有移動到某一物件上時  該物件旁邊就會顯示出該物件的名子
		滑鼠離開物件時  物件名稱便會消失
	6. 按下數字1~7   便可以轉換  1~7集不同的 star wars episode
	7. 在右邊的network顯示中  關西越強烈的之間的線就會越粗  線的粗細是以json的value決定

### Visualization
+ The width of each link is visualized based on the value of the link.
