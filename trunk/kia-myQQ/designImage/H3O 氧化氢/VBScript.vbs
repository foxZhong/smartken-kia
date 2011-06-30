Dim UserNum
Dim UserStatus
Dim Path
Dim strQQMailTip
Dim ShowStatus
Dim foldbottom
Dim bMsgInside
Dim CurrentWidth
Dim CurrentHeight
Dim PlugMngHeight
Dim PetState
Dim RecyclerPath()
Dim magicflag
Dim barflag
Dim barflag1
Dim ntopdistance
Dim strTenpayTip

Sub Window_OnInit()
	Window.GetScriptVersion "1.0"
	UserStatus = "(离线)"
	Path = "NewSkins\\QQ2008\\"
	ShowStatus = 1
	UserNum = "0"
	If 1 = ShowStatus Then
	      UserNum = UserNum + UserStatus
	End If       
        strQQMailTip = ""
	bMsginside = 0
	PetState = 1
End Sub
Sub Window_OnSize(cx,cy)
	Window.LockPaint()
	CurrentWidth = cx
	CurrentHeight = cy
	StatusEdit.Left = QQNumber.left
              ToolBarBackgroundC.top = 500
	ToolBarBackgroundC.width = 167
	ToolBarBackgroundL.top = ToolBarBackgroundC.top 
	ToolBarBackgroundR.left = 257
	ToolBarBackgroundR.top = ToolBarBackgroundC.top 
	BackgroundRB.left  = 257
	BackgroundRB.top = 499
	BackgroundLB.top = 499
	BackgroundRT.left  = 257
	BackgroundT.width = 167
	BackgroundL.height = 359
	BackgroundR.left  = 257
	BackgroundR.height = 359
	BackgroundB.top = 499
	BackgroundB.width = 244
	BackgroundC.width = 244
	BackgroundC.height = 359
        Bar1.width    = 244
        Bar1.left    = cx-258
        Bar1.top    = cy-375
        Bar1.height    = 300
	If barflag = 0 Then
	        Bar1.height = 360
	else
	        Bar1.height = 360
	End If
              StatusWeather.left = 210
              
	MobileMsgButton.top = 103
	GameButton.top = 103
	petOpenBtn.top = 103
	QQTV.top = 103
        QQMusic.top= 103
        TTButton.top=103
      
	CalcStatusPos cx, cy

        MailButton.label = strQQMailTip        
     	Window.UnLockPaint()
End Sub
'----------------------------------************************----------------------------
Sub QQStatus_onClick()
	s = QQStatus.left
	Window.ExeCommand 63,s
End Sub
'--------------------------------************************--------------------------------
Sub MinButton_onClick()
	Window.ExeCommand 1,2
End Sub

Sub CloseButton_onClick()
	Window.ExeCommand 1,3
End Sub

Sub ColorButton_onClick()
        Window.ExeCommand 4,7
End Sub

Sub StatusButton_onClick()
	s = CStr(StatusButton.Left + StatusButton.width - 10)&"."&CStr(StatusButton.Top + StatusButton.height - 8)
	Window.ExeCommand 6,s
End Sub

sub StatusPic_onMouseMove(nX,nY)
	s = CStr(StatusPic.Left) & "." & CStr(StatusPic.Top) & "." & CStr(StatusPic.width) & "." & CStr(StatusPic.height)
	Window.ExeCommand 20,s
end Sub

sub StatusPic_onMouseLeave()
	s = CStr(StatusPic.Left) & "." & CStr(StatusPic.Top) & "." & CStr(StatusPic.width) & "." & CStr(StatusPic.height)
	Window.ExeCommand 21,s
end Sub

Sub StatusPic_onClick()
	Window.ExeCommand 60,2
End Sub

sub StatusWeather_onMouseMove(nX,nY)
	s = CStr(StatusWeather.Left) & "." & CStr(StatusWeather.Top) & "." & CStr(StatusWeather.width) & "." & CStr(StatusWeather.height)
	Window.ExeCommand 31,s
end Sub

sub StatusWeather_onMouseLeave()
	s = CStr(StatusWeather.Left) & "." & CStr(StatusWeather.Top) & "." & CStr(StatusWeather.width) & "." & CStr(StatusWeather.height)
	Window.ExeCommand 30,s
end Sub

Sub StatusWeather_onClick()
	Window.ExeCommand 61,0
End Sub

Sub QZoneMsgCenterButton_onClick()
	QZoneMsgCenterButton.label = "(" + "0" + ")"
	Window.ExeCommand 66,0
End Sub	

Sub MailButton_onClick()
	Window.ExeCommand 7,1	
End Sub

Sub Window_onClick(code, Name)
	Window.LockPaint()
	Window.DisableBar CStr(Name)
	Window.ExeCommand code,CStr(Name)
	Window.UnLockPaint()
End Sub

Sub PaymentButton_onClick()
	Window.ExeCommand 4,8
End Sub

Sub MobileMsgButton_onClick()
	Window.ExeCommand 4,2
End Sub

Sub GameButton_onClick()
	Window.ExeCommand 4,5
End Sub

sub petOpenBtn_onClick()
	Window.ExeCommand 40,12
End Sub

Sub QQMusic_OnClick()
	Window.ExeCommand 25,1
End Sub

Sub QQTV_onClick()
	Window.ExeCommand 26,1
End Sub

Sub TTButton_onClick()
	Window.ExeCommand 4,4
End Sub

Sub MenuButton_onClick()
	s = CStr(MenuButton.Left)&"."&CStr(MenuButton.Top)
	Window.ExeCommand 5,s
End Sub

Sub ContentsButton_onClick()
	Window.ExeCommand 4,9
End Sub

Sub SearchButton_onClick()
	Window.ExeCommand 4,3
End Sub

Sub MsgManagerButton_onClick()
	Window.ExeCommand 4,6
End Sub

Sub DNAButton_onClick()
	Window.ExeCommand 27,1
End Sub

Sub DisplayPlug_onClick() 
        Window.LockPaint()
        If barflag = 0 Then
                barflag = 1 

                If barflag1=0 Then
	        
                      MobileMsgButton.visible="true"
	        GameButton.visible="true"
	        petOpenBtn.visible="true"
	        QQTV.visible="true"
                QQMusic.visible="true"
                TTbutton.visible="true"

                Else
	        
                      MobileMsgButton.visible="false"
	        GameButton.visible="false"
	        petOpenBtn.visible="false"
	        QQTV.visible="false"
                      QQMusic.visible="false"
                 TTbutton.visible="false"
                End If
                window.RebuildRGN


	Else
                barflag = 0
	        
	        MobileMsgButton.visible="false"
	        GameButton.visible="false"
	        petOpenBtn.visible="false"
	        QQTV.visible="false"
                      QQMusic.visible="false"
                  TTbutton.visible="false"
	        window.RebuildRGN
	End If	
        Window.UnLockPaint()
End Sub
 
Sub CalcStatusPos(cx, cy)
	StatusEdit.Left = QQNumber.left
	IF bShowDNA = 1 Then
		QQStatus.Left = QQNumber.Left + QQNumber.width + 2
		QQStatus.width = QQStatusText.textlength + 4
                            QQNumber.width = QQNumber.textlength
	Else
		QQStatus.Left = QQNumber.Left + QQNumber.width + 2
		QQStatus.width = QQStatusText.textlength + 4
                            QQNumber.width = QQNumber.textlength
	End If

	If QQStatus.Left > cx - 0 Then
		QQStatus.Left = cx - 0
		QQStatus.visible = False
	ElseIf QQStatus.Left + QQStatus.width > cx - 0 Then
		QQStatus.visible = true
		QQStatus.width = cx - 0 - QQStatus.Left
	Else
		QQStatus.visible = True
	End If
	
	StatusEdit.width = cx - StatusEdit.left - 5
End Sub

'处理QQ程序发来的事件
Sub Window_OnNotify(code ,var)
	If code = 1 Then 
	    '设置当前的Uin
	    UserNum = var
	    If 0 = ShowStatus Then
			QQNumber.value = UserNum
		Else
		   	QQNumber.value = UserNum
			QQStatusText.value = UserStatus
			QQStatus.label = UserStatus
		End If	
	ElseIf code = 2 Then
		'闪系统消息按钮 var 为1是开始闪。为2是停止
		If(var = 1) Then
			MsgManagerButton.StopFlash
			MsgManagerButton.Flash 30
		Else
			MsgManagerButton.StopFlash
		End If
	ElseIf code = 3 then
		'闪状态按钮 var 为0,1,2,3是对应的ico。为4表示停止
		If var = 0 Then
			StatusPic.ico = "Online.ico"		
		ElseIf var = 1 Then
			StatusPic.ico = "leave.ico"		
		ElseIf var = 2 Then
			StatusPic.ico = "invisible.ico"		
		ElseIf var = 3 Then
			StatusPic.ico = "Offline.ico"		
		ElseIf var = 4 Then
			StatusPic.Ico = StatusIco	
		End If
	ElseIf code = 4 Then
		'设置那个Bar在最前
		Window_onClick 2,Var
	ElseIf code = 5 Then
		QQStatus.Disabled=0
		'设置当前的状态。
		If var = 10 Then	
			UserStatus = "[在线]"		
			StatusIco = "online.ico"
		ElseIf var = 20 Then
			UserStatus = "[离线]"			
			QQStatus.Disabled=1
			StatusIco = "exit.ico"
		ElseIf var = 30 Then	
			UserStatus = "[离开]"		
			StatusIco = "leave.ico"
		ElseIf var = 40 Then	
			UserStatus = "[隐身]"		
			StatusIco = "hide.ico"
		ElseIf var = 50 Then
			UserStatus = "[忙碌]"
			StatusIco = "busy.ico"
		ElseIf var = 60 Then
			UserStatus = "[Q我]"
			StatusIco = "qme.ico"
		ElseIf var = 70 Then
			UserStatus = "[静音]"
			StatusIco = "nobother.ico"
		End If
		StatusButton.ico = StatusIco
		If 0 = ShowStatus Then
			QQNumber.value = UserNum
		Else
		   	QQNumber.value = UserNum
			QQStatusText.value = UserStatus
			QQStatus.label = UserStatus
		End If
	ElseIf code  = 6 Then
		'设置Skin的起始路径
		Path = Var	
	ElseIf code = 25 Then
		' 皮肤推送
		if(var = 1) then
			ColorButton.SetLighting(true)
		else
			ColorButton.SetLighting(false)
		end If

       ElseIf code = 100 Then
		'改变QQMail的提示
		if( var = 0 ) then
		    strQQMailTip = "(" + "0" + ")"
		else
		    strQQMailTip = "(" + CStr(var) + ")"
		end if
		MailButton.label = strQQMailTip		
       	ElseIf code = 107 Then
		UserStatus = "[" + CStr(var) + "]"
		QQStatusText.value = UserStatus
		QQStatus.label = UserStatus
		CalcStatusPos CurrentWidth, CurrentHeight
	ElseIf code = 108 then
		if(var = 1) then
			StatusEdit.bInside = TRUE
		else
			StatusEdit.bInside = FALSE
		end If	
'-----------------***********************---------------------------
			ElseIf code = 109 Then
		pos = QQStatus.left - QQNumber.left
		if(var = 0) then
			Window.ExeCommand 65,pos
		Else
			Window.ExeCommand 64,pos
		end If
'-----------------********************----------------------------------
	ElseIf code = 116 then
		If (var = -1) Then
			QZoneMsgCenterButton.label = "(" + "0" + ")"
		Else
			QZoneMsgCenterButton.label = "(" + CStr(var) + ")"
		end If
	End If	
End Sub