document.addEventListener("DOMContentLoaded", () => {
  let modal = document.querySelector("div#modal");
  modal.querySelector("span").addEventListener("click", (e) => {
    // 임의로 생성된 div_search Bok
    // modal 과 별개 생성을 하였으므로
    //  div_search box  를 remove하고 modal을 감춘다
    document.querySelector("div#div_search").remove();
    modal.style.display = "none";
  });
  document.querySelector("form#book_input").addEventListener("keydown", (e) => {
    let key = e.key;
    let tagName = e.target.tagName;
    let id = e.target.id;
    let className = e.target.className;

    if (key === "Enter" && tagName === "INPUT") {
      let text = e.target.value;
      let urlPath = rootPath;

      if (id === "bk_ccode") {
        modal.style.display = "block";
        urlPath += `/comp/search?cp_title=${text}`;
      } else if (id === "bk_acode") {
        modal.style.display = "block";
        urlPath += `/author/search?au_name=${text}`;
      }
      if (className === "search") {
        modal.style.display = "block";
        fetch(urlPath)
          .then((res) => {
            return res.text();
          })
          .then((result) => {
            let div = document.createElement("div");
            div.innerHTML = result;
            //  새로운 element(tag)
            div.setAttribute("id", "div_search");
            // id 추가
            document.querySelector("body").appendChild(div);
          });
      }
    } // alert("저자찾기" + text);
  });

  document
    .querySelector("form#book_input button.btn_save")
    .addEventListener("click", (e) => {
      let form = document.querySelector("form#book_input");

      let bk_isbn = form.querySelector("input#bk_isbn");
      let bk_title = form.querySelector("input#bk_title");
      let bk_ccode = form.querySelector("input#bk_ccode");
      let bk_acdoe = form.querySelector("input#bk_acdoe");
      let bk_price = form.querySelector("input#bk_price");
      let bk_page = form.querySelector("input#bk_page");

      // 유효성검사
      if (bk_isbn.value === "") {
        alert("ISBN은 반드시입력하세요");
        bk_isbn.focus();
        return false;
      }
      if (bk_isbn.value.length !== 13) {
        alert("ISBN은 13자리여야합니다");
        bk_isbn.focus();
        return false;
      }
      if (bk_title.value === "") {
        alert("도서명은 반드시 입력하세요");
        bk_title.focus();
        return false;
      }
      form.submit();
    });
});
