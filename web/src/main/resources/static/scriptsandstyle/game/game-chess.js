function getParentLength(){
    return Math.min(window.innerWidth, window.innerHeight, (window.innerWidth + window.innerHeight)/4);
}

function getChildLength(){
    return getParentLength()/8;
}

function handleClick(event){
    console.log("clicked");
    console.log(event.currentTarget);
    const piece = event.currentTarget.piece;
    const move = event.currentTarget.move;

    //remember to check side at some point
    if(move != null){

    }
    if(piece != null && !piece.clicked){
        clientEvent(new ClientState(1, null, null, piece.id, null));
        return;
    }
    if(piece != null && piece.clicked){
        //poista movet
        return;
    }
    chessboard.clearMoves();
}

class GridSquare extends HTMLDivElement{
    constructor() {
        super();
        this.classList.add("grid-square");
    }
}
customElements.define('grid-square', GridSquare, {extends: 'div'});

class PieceSquare extends HTMLDivElement{

    constructor() {
        super();
        this.classList.add("piece-square");
    }

}
customElements.define("piece-square", PieceSquare, {extends: 'div'});

class MoveSquare extends HTMLDivElement{
    constructor() {
        super();
        this.classList.add("move-square");
    }
}
customElements.define("move-square", MoveSquare, {extends: 'div'});

function getGridSquare(coords){
    console.log("create gridsquare");
    const gridSquare = document.createElement('grid-square', {is: 'div'});

    gridSquare.coords = coords;

    gridSquare.style.position = 'absolute';
    gridSquare.style.backgroundColor = 'yellow';

    gridSquare.style.width = getChildLength()+'px';
    gridSquare.style.height = getChildLength()+'px';
    gridSquare.style.left = (coords.x-1)*getChildLength()+'px';
    gridSquare.style.top = (8-coords.y+1-1)*getChildLength()+'px';


    return gridSquare;
}

function getPieceSquare(piece){

    const pieceSquare = document.createElement('piece-square',{is:'div'});

    pieceSquare.style.position = 'absolute';
    pieceSquare.style.backgroundColor = 'green';

    pieceSquare.piece = piece;
    pieceSquare.style.width = getChildLength()+'px';
    pieceSquare.style.height = getChildLength()+'px';

    //dependent of the side!
    //whiteside

    return pieceSquare;
}

function getMoveSquare(move){
    const moveSquare = document.createElement('move-square', {is: 'div'});

    moveSquare.style.position = 'absolute';
    moveSquare.style.backgroundColor = 'red';

    moveSquare.coords = new Coords(move.x, move.y);
    moveSquare.style.width = getChildLength()+'px';
    moveSquare.style.height = getChildLength()+'px';

    return moveSquare;
}

class Chessboard extends HTMLDivElement{

    constructor() {
        super();

        this.pieces = [];
        this.moves = [];

        this.initGrid();
        this.handleResize();

        console.log("children")
        console.log(this.children)
        window.addEventListener('resize', this.handleResize.bind(this));
    }

    initGrid(){
        for(let i = 1; i <= 8; i++){
            for(let j = 1; j <= 8; j++){
                const gridSquare = getGridSquare(new Coords(j, i));
                this.appendChild(gridSquare);
                this.lastChild.addEventListener("click", handleClick);
            }
        }
    }

    setChildrenSize(){

        for(let gridSquare of this.children){

            gridSquare.style.left = (gridSquare.coords.x-1)*getChildLength()+'px';
            gridSquare.style.top = (8-gridSquare.coords.y+1-1)*getChildLength()+'px';
            gridSquare.style.width = getChildLength()+'px';
            gridSquare.style.height = getChildLength()+'px';

            for(let child of gridSquare.children){
                child.style.width = getChildLength()+'px';
                child.style.height = getChildLength()+'px';
            }
        }
    }

    setSize(){
        this.style.width = getParentLength()+"px";
        this.style.height = getParentLength()+"px";
    }

    clearPieces(){
        this.pieces = [];

        for (let gridSquare of this.children){
            gridSquare.piece = null;
            for(let child of gridSquare.children){
                if(child.nodeName == "PIECE-SQUARE"){
                    gridSquare.removeChild(child)
                    continue;
                }
            }
        }
    }

    clearMoves(){
        this.moves = [];

        for (let gridSquare of this.children){
            gridSquare.move = null;
            for(let child of gridSquare.children){
                if(child.nodeName == "MOVE-SQUARE"){
                    gridSquare.removeChild(child)
                    continue;
                }
            }
        }
    }

    clearGrid(){
        this.clearPieces();
        this.clearMoves();
    }

    createChildComponents(pieces){
        for(let piece of pieces){
            if(!piece.isAlive()) continue;
            const pieceSquare = getPieceSquare(piece);

            for (let gridSquare of this.children){
                if(gridSquare.coords.x === piece.coords.x && gridSquare.coords.y === piece.coords.y){
                    gridSquare.appendChild(pieceSquare);
                    gridSquare.piece = piece;
                    this.pieces.push(pieceSquare);
                }
            }
        }

        console.log(this.children);
    }

    updateBoard(pieces){
        this.clearGrid();
        this.createChildComponents(pieces);
    }

    addMoves(pieceData){

        for(let move of pieceData.moves){
            const moveSquare = getMoveSquare(move);
            for (let gridSquare of this.children){
                if(gridSquare.coords.x === move.x && gridSquare.coords.y === move.y){
                    gridSquare.appendChild(moveSquare);
                    gridSquare.move = move;
                    this.moves.push(moveSquare);
                }
            }
        }

    }

    handleResize(){
        this.setSize();
        this.setChildrenSize()
    }
}

customElements.define("chess-board", Chessboard, {extends: 'div'});


