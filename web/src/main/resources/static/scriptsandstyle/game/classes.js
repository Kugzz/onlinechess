
class Chessboard extends HTMLDivElement{

    constructor() {
        super();

    }


}

customElements.define("chess-board", Chessboard, {extends: 'div'});

