using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestaoDoConecimento.Dados
{
    [Table("atividade")]
    public class Atividade
    {
        
        [Key]
        [Column("id_atividade")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("nome")]
        [StringLength(200)]
        [Display(Name = "Atividade")]
        public string NomeAtividade { get; set; }

        [ForeignKey("Pessoa")]
        public long PessoaId { get; set; }

        [Column("local")]
        public string Local { get; set; }

        [Display(Name = "Data de Inicio")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataInicio { get; set; }

        [Display(Name = "Hora Inicio")]
        [DisplayFormat(DataFormatString = "{0:h\\:mm}")]
        public String HoraInicio { get; set; }

        [Display(Name = "Data de Térmimo")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataFim { get; set; }

        [Display(Name = "Hora Final")]
        [DisplayFormat(DataFormatString = "{0:h\\:mm}")]
        public String HoraFim { get; set; }

        [Display(Name = "Atividade Relacionada")]
        [Column("tipo_de_atividade")]
        public TipoAtividade TipoDeAtividade { get; set; }

        [Column("descricao")]
        public string Descricao { get; set; }

        [Column("problema")]
        [ForeignKey("problema")]
        public IEnumerable<Problema> Solucoes { get; set; }

        [Column("solucao")]
        public IEnumerable<Solucao> Problemas { get; set; }

        [Column("pessoa")]
        [ForeignKey("PessoaId")]
        public Pessoa Pessoa { get; set; }
    }
}
