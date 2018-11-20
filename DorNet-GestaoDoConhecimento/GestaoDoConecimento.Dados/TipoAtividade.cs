using System.ComponentModel.DataAnnotations;

namespace GestaoDoConecimento.Dados
{
    public enum TipoAtividade
    {
        [Display(Name = "Analise")]
        ANALISE,
        [Display(Name = "Levantamento de Requisitos")]
        LEVANTAMETO_DE_REQUISITOS,
        [Display(Name = "Desenvolvimento")]
        DESENVOLVIMENTO,
        [Display(Name = "Teste")]
        TESTE,
        [Display(Name = "Implantacao")]
        IMPLANTACAO,
        [Display(Name = "Outros")]
        OUTROS
    }
}