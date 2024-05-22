/*
모듈 패턴은 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 객체를 구성한다.
JavaScript 의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다.
*/

var gridService = (function(){

	function getTreeData(data){
		
		const tree = [];
	  	const childrenMap = {};
	
		// 모든 항목을 객체로 변환하고 childrenMap에 저장
		data.forEach(item => {
			if(item.level < 3){ //3depth 마지막은 자식선택자 없다
				item._children = [];
				childrenMap[item.id] = item;
			}
		});
	
		// 각 항목을 순회하며 부모의 _children에 추가
		data.forEach(item => {
			if (item.parent_id === null) {
			
				// 부모가 없으면 최상위 노드
				tree.push(item);
				
			} else {
				// 부모가 있으면 부모의 _children에 추가
				if (childrenMap[item.parent_id]) {
					childrenMap[item.parent_id]._children.push(item);
				}
			}
		});
	
	  	return tree;
	}
	
	return {
		getTreeData: getTreeData
	};
	
})(); //gridService