using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace AluguelCarros.Models
{
    [Table("endereco")]
    public class Endereco
    {
        [Key]
        [Column("id_endereco")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        [Column("logradouro")]
        [StringLength(100)]
        public string Logradouro { get; set; }

        [Column("numero")]
        public int Numero { get; set; }

        [StringLength(50)]
        [Column("bairro")]
        public string Bairro { get; set; }

        [StringLength(50)]
        [Column("municipio")]
        public string Municipio { get; set; }

        [StringLength(2)]
        [Column("estado")]
        public string Uf { get; set; }

        [Column("cep")]
        [StringLength(8)]
        public String Cep { get; set; }

    }
}