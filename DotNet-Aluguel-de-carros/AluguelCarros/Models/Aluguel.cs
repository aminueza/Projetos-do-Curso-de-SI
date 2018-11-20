using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AluguelCarros.Models
{
    [Table("aluguel")]
    public class Aluguel
    {
        [Key]
        [Column("id_aluguel")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        public Carro Carro { get; set; }

        public Pessoa Pessoa { get; set; }

        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        [Column("data_aluguel")]
        public DateTime DataAluguel { get; set; }

        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        [Column("data_devolucao")]
        public DateTime DataDevolucao { get; set; }
    }
}