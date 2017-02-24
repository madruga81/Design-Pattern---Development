package br.com.fiap;
//Concrete mediator
class Mediator {
 
    BotaoVisualizar btnView;
    BotaoBusca btnSearch;
    BotaoReserva btnBook;
    Tela show;
 
    void registerView(BotaoVisualizar v) {
        btnView = v;
    }
 
    void registerSearch(BotaoBusca s) {
        btnSearch = s;
    }
 
    void registerBook(BotaoReserva b) {
        btnBook = b;
    }
 
    void registerDisplay(Tela d) {
        show = d;
    }
 
    void book() {
        btnBook.setEnabled(false);
        btnView.setEnabled(true);
        btnSearch.setEnabled(true);
        show.setText("efetuando reserva de livro…");
    }
 
    void view() {
        btnView.setEnabled(false);
        btnSearch.setEnabled(true);
        btnBook.setEnabled(true);
        show.setText("visualizando livro…");
    }
 
    void search() {
        btnSearch.setEnabled(false);
        btnView.setEnabled(true);
        btnBook.setEnabled(true);
        show.setText("procurando livro…");
    }
 
}
