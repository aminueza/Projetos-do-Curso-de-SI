using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestaoDoConecimento.Dados
{
    [Table("Conhecimento")]
    public class Conhecimento
    {
        [Key]
        [Column("id_conhecimento")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }
        public Pessoa Pessoa { get; set; }
        public Atividade Atividade { get; set; }
        public Problema Problema { get; set; }
        public Solucao Solucao { get; set; }
    }
}
