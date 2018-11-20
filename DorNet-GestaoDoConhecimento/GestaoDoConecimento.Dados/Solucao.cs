using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace GestaoDoConecimento.Dados
{
    [Table("solucao")]
    public class Solucao
    {
        [Key]
        [Column("id_solucao")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("Atividade")]
        [Display(Name = "Atividade")]
        public long AtividadeId { get; set; }

        [Column("nome")]
        [StringLength(200)]
        [Display(Name = "Solução")]
        public string NomeSolucao { get; set; }

        [Column("descricao")]
        public string Descricao { get; set; }

        [Column("atividade")]
        [ForeignKey("AtividadeId")]
        [Display(Name = "Atividade")]
        public Atividade Atividade { get; set; }
    }
}