package steps_definition;

import base_class.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import page_objects.SeuBarrigaContasPage;
import page_objects.SeuBarrigaCriarMovimentacaoPage;
import page_objects.SeuBarrigaHomePage;
import page_objects.SeuBarrigaLoginPage;
import java.util.Collections;
import java.util.List;



public class CriarMovimentacaoSteps extends BaseSteps {
    SeuBarrigaLoginPage loginPage = new SeuBarrigaLoginPage(browser);
    SeuBarrigaContasPage paginaContas = new SeuBarrigaContasPage(browser);
    SeuBarrigaHomePage paginaInicial = new SeuBarrigaHomePage(browser);
    SeuBarrigaCriarMovimentacaoPage paginaMovimentacao = new SeuBarrigaCriarMovimentacaoPage(browser);

    @Dado("que o usuario esteja logado")
    public void queOUsuarioEstejaLogado() {
        loginPage.abrir();
        loginPage.preencherUsername();
        loginPage.preencherPassword();
        loginPage.clicarBtnEntrar();
        screenshot();
    }

    @Dado("que o usuario que possua uma conta cadastrada")
    public void queOUsuarioQuePossuaUmaContaCadastrada() {
        paginaInicial.clicarBntContas();
        paginaInicial.clicarListarContas();
        Assert.assertTrue(paginaContas.contacadastrda());
        screenshot();
    }

    @Quando("o usuario clicar na aba Criar Movimentacao")
    public void oUsuarioClicarNaAbaCriarMovimentacao() {
        paginaInicial.criarMovimentacao();
    }

    @Quando("o usuario preencher o Tipo da Movimentacao com {string}")
    public void oUsuarioPreencherOTipoDaMovimentacaoCom(String string) {
        paginaMovimentacao.tipoDeMovimetacao(string);
        screenshot();
    }

    @Quando("o usuario preencher a Data da Movimentacao com {string}")
    public void oUsuarioPreencherADataDaMovimentacaoCom(String string) {
        paginaMovimentacao.preencherDataMov(string);
        screenshot();
    }
    @Quando("o usuario preencher a Data do Pagamento com {string}")
    public void oUsuarioPreencherADataDoPagamentoCom(String string) {
        paginaMovimentacao.preencherDataPag(string);
        screenshot();

    }
    @Quando("o usuario preencher a Descricao com {string}")
    public void oUsuarioPreencherADescricaoCom(String string) {
        paginaMovimentacao.preencherDescricao(string);
        screenshot();
    }
    @Quando("o usuario preencher o Interessado com {string}")
    public void oUsuarioPreencherOInteressadoCom(String string) {
        paginaMovimentacao.preencherInteressado(string);
        screenshot();
    }
    @Quando("o usuario preencher o valor com {string}")
    public void oUsuarioPreencherOValorCom(String string) {
        paginaMovimentacao.preencheValor(string);
        screenshot();
    }
    @Quando("o usuario escolher a conta {string}")
    public void oUsuarioEscolherAConta(String string) {
        paginaMovimentacao.preencheConta(string);
        screenshot();
    }
    @Quando("o usuario alterar a situação para {string}")
    public void oUsuarioAlterarASituaçãoPara(String string) {
        paginaMovimentacao.preencheSituacao(string);
        screenshot();
    }
    @Quando("o usuario clicar no botao salvar")
    public void oUsuarioClicarNoBotaoSalvar() {
        paginaMovimentacao.clicarSalvar();
    }
    @Entao("o sistema deve apresentar uma mensagem de {string}")
    public void oSistemaDeveApresentarUmaMensagemDe(String resultadoDesejado) {
        String msgTela = paginaMovimentacao.getResultSalvar();
        Assert.assertEquals(resultadoDesejado,msgTela);
        screenshot();
        paginaMovimentacao.clicarSair();
    }

    @Entao("o sistema deve apresentar uma mensagem de erro com {string}")
    public void oSistemaDeveApresentarUmaMensagemDeErroCom(String fraseProcurada) {
       List<String> erros = paginaMovimentacao.getResultErro();
        System.out.println(erros);
       Assert.assertTrue(erros.containsAll(Collections.singleton(fraseProcurada)));
       screenshot();
    }
}
