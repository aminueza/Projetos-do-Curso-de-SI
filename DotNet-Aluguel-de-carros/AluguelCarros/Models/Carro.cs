using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace AluguelCarros.Models
{
    [Table("carro")]
    public class Carro
    {
        [Key]
        [Column("id_carro")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        [Column("modelo")]
        [StringLength(50)]
        public string Modelo { get; set; }

        [Column("marca")]
        [StringLength(50)]
        public string Marca { get; set; }

        [Column("preco")]
        [StringLength(50)]
        public String Valor { get; set; }

        [Column("fabricante")]
        public Fabricante Fabricante { get; set; }
    }
}