var main = {
    init : function () {
        var _this = this;

        document.getElementById("btn-save")?.addEventListener('click', () => {
                _this.save();
            });

        document.getElementById("btn-update")?.addEventListener('click', () => {
                _this.update();
            });

        document.getElementById("btn-delete")?.addEventListener('click', () => {
                _this.delete();
            });

    },
    save : function () {
        var data = {
            id : document.getElementById("id").value,
            name : document.getElementById("name").value,
            age : document.getElementById("age").value,
            phone : document.getElementById("phone").value,
            email : document.getElementById("email").value,
            address : document.getElementById("address").value,
            dept : document.getElementById("dept").value
        };

        /*JSON 저장*/
        var reqJson = new Object();
        reqJson.id = data.id;
        reqJson.name = data.name;
        reqJson.age = data.age;
        reqJson.phone = data.phone;
        reqJson.email = data.email;
        reqJson.addr = data.address;
        reqJson.dept = data.dept;

        var httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = () => {
            if(httpRequest.readyState === XMLHttpRequest.DONE) {
                if(httpRequest.status === 200) {
                    console.log('연결 성공');
                } else {
                    alert('연결 실패');
                }
            }
        }

        /*POST 요청*/
        httpRequest.open('POST', '/api/emp', true);
        /*응답 타입 JSON*/
        httpRequest.responseType = "json";
        /*content 타입*/
        httpRequest.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

        httpRequest.onload = (res) => {
            if(httpRequest.readyState === 4) {
                if(httpRequest.status === 200) {
                    alert('추가 성공');
                    window.location.href='/employee/employeeList';
                } else {
                    alert('추가 실패');
                }
            }
        }

        /*전송*/
        httpRequest.send(JSON.stringify(reqJson));

    },
    update : function () {
        var data = {
            name : document.getElementById("name").value,
            age : document.getElementById("age").value,
            phone : document.getElementById("phone").value,
            email : document.getElementById("email").value,
            addr : document.getElementById("address").value,
            dept : document.getElementById("dept").value
        };

        var id = document.getElementById("id").value;

        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = () => {
            if(xhr.readyState === XMLHttpRequest.DONE) {
                if(xhr.status === 200) {
                    console.log("연결 성공");
                } else {
                    alert("서버 연결 실패");
                }
            }
        }

        xhr.open('PUT', '/api/emp/' + id, true);
        xhr.responseType = "json";
        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
        xhr.send(JSON.stringify(data));

        xhr.onload = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    alert("수정 완료");
                    window.location.href='/employee/employeeList';
                } else {
                    alert("수정 실패, 오류 발생");
                    alert(xhr.status + ", " + xhr.statusText);
                }
            }
        }

    },

    delete : function () {
        if (!confirm("정말로 삭제하겠습니까?")) {
            return;
        }
        var id = document.getElementById("id").value;

        var xhr = new XMLHttpRequest;

        xhr.onreadystatechange = () => {
            if(xhr.readyState === XMLHttpRequest.DONE) {
                if(xhr.status !== 200) {
                    console.log("연결 실패");
                }
            }
        }

        xhr.open('DELETE', '/api/emp/' + id, true);
        xhr.responseType = "json";
        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');

        xhr.onload = () => {
            if(xhr.readyState === 4) {
                if(xhr.status === 200) {
                    alert("삭제 되었습니다.");
                    window.location.href='/employee/employeeList';
                } else {
                    console.log(xhr.status + ", " + xhr.statusText);
                    alert("삭제 실패, 에러");
                }
            }
        }

        xhr.send(null);
    }
};
main.init();