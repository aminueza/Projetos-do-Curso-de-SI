using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace AluguelCarros.Models
{
    [Table("pessoa")]
    public class Pessoa
    {
        [Key]
        [Column("id_pessoa")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        [Column("nome")]
        [StringLength(50)]
        public String Nome { get; set; }

        [Column("cpf")]
        [StringLength(11)]
        public String Cpf { get; set; }

        [Column("cnh")]
        [StringLength(10)]
        public String Habilitacao { get; set; }

        [Column("telefone")]
        public List<Telefone> Telefones { get; set; }

        [Column("endereco")]
        public Endereco Endereco { get; set; }
    }
}