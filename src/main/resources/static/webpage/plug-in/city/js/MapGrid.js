;(function(win){function MapGrid(b,t){this.dom=document.querySelector(b);this.init(this.dom,t);}
MapGrid.prototype={init:function(b,t){mapPrive._init(b,t)}};var mapPrive=(function(){return{_html:function(){var html='<div class="editmap_header">'+
'		<div class="editmap_title"></div>'+
'		<input type="text" id="editmap_id" class="editmap_id" placeholder="请输入关键字,选定后搜索"/>	'+
'		<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>'+
'</div>'+
'<div class="editmap_mapAll" id="editmap_mapAll">'+
' 		<div id="tip" style="display: none"></div>'+
'</div>'+
'<div id="baiduTip" style="display: none"></div>'+
'<div class="editmMap_btnAll">'+
'		<button class="editmMap_btnAll_ok" type="button">确认</button>'+
'		<button class="editmMap_btnAll_colse" type="button">取消</button>'+
'</div>';return html;},_init:function(b,t){this.dom=b;this._data(t);},_data:function(d){var parems={type:d.type||gouldMap,callback:d.callback||function(){}}
this._bind(parems);},_bind:function(d){var bom,ovel,self=this;this.dom.addEventListener('click',function(){bom=document.createElement('div');bom.className='editmap_map';ovel=document.createElement('div');ovel.className='ovel';document.body.appendChild(bom);document.body.appendChild(ovel);var map_title=bom.querySelector('.editmap_title');bom.innerHTML=self._html();var mapOk=bom.querySelector('.editmMap_btnAll_ok'),mapColse=bom.querySelector('.editmMap_btnAll_colse');returnMap(d.type);var _self=this;if(d.type==gouldMap){bom.querySelector('#tip').style='block';setTimeout(function(){gouldMap.createMap(bom.querySelector('#editmap_mapAll'));mapOk.addEventListener('click',function(){var lng=bom.querySelector('.map_longitude').getAttribute('data-getlng');var lat=bom.querySelector('.map_latitude').getAttribute('data-getlat');_self.setAttribute('data-value',lng+','+lat);_self.value=lng+','+lat;document.body.removeChild(ovel);document.body.removeChild(bom);$('.amap-sug-result').remove();d.callback(lng,lat);});},500);}else{bom.querySelector('#baiduTip').style.display='block';setTimeout(function(){baiduMap.createMap(bom.querySelector('#editmap_mapAll'));mapOk.addEventListener('click',function(){var lng=bom.querySelector('.map_longitude').getAttribute('data-getlng');var lat=bom.querySelector('.map_latitude').getAttribute('data-getlat');_self.setAttribute('data-value',lng+','+lat);_self.value=lng+','+lat;document.body.removeChild(ovel);document.body.removeChild(bom);$('.amap-sug-result').remove();d.callback(lng,lat);});},500);}
mapColse.addEventListener('click',function(){document.body.removeChild(ovel);document.body.removeChild(bom);$('.amap-sug-result').remove();})
self._center(bom);setTimeout(function(){self._btnBInd(bom,self.dom);},500);},false);},_btnBInd:function(b,d){},_center:function(b){var win=($(window).width()-$(b).width())/2;var hei=($(window).height()-$(b).height())/2;$(b).css({left:win,top:hei});$(window).on('resize',function(){var win=($(window).width()-$(b).width())/2;var hei=($(window).height()-$(b).height())/2;$(b).css({left:win,top:hei});});}}})();win.MapGrid=MapGrid;}(window));