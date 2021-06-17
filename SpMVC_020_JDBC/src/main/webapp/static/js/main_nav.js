document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav#main_nav");

  nav.addEventListener("click", (e) => {
    let tagName = e.target.tagName;
    //   '${rootPaht}' 일종의 매개변수같은 역할을 한다
    let urlPath = `${rootPath}`;
    // `` backtit: 역작은 따옴표 JS에서 변수를 포함하는 문자열을 생성할때 사용한다
    if (tagName === "LI") {
      let menuText = e.target.textContent;
      //   urlPath += rootPath+"/"
      if (menuText === "HOME") {
        urlPath += "/";
      } else if (menuText === "도서정보") {
        // location.href="${rootPath}/books"
        // 를 일일이 사용하지않기위해 urlPath라는 변수를 만들어서
        // 자바 스립트에서 사용하는 변수 문자열 생성 ``기호를 이용해서
        //jsp 파일에서 같이 사용해버리면안되기때문에 js에서 분리를한다
        // 각각의 메뉴를 클릭했을때 공통으로 필요한 rootPath 문자열을 변수에 셋팅
        // urlPath에 자기자신의 list항목을 지정해주고
        // 맨아랫쪽에 한번에 적용하는 location.href=urlPath; 항목으로 대체하여 사용하였다
        urlPath += "/books";
      } else if (menuText === "출판사정보") {
        urlPath += "/comp";
      } else if (menuText === "저자정보") {
        urlPath += "/author";
      } else if (menuText === "로그인") {
        urlPath += "/member/login";
      } else if (menuText === "회원가입") {
        urlPath += "/member/join";
      } else if (menuText === "로그아웃") {
        urlPath += "/member/logout";
      } else if (e.target.id === "mypage") {
        urlPath += "/member/mypage";
      }
      //   alert (`내가 가야할곳 ${urlPath}`);
      location.href = urlPath;
    }
  });
});
