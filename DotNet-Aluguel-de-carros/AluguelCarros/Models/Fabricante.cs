using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace AluguelCarros.Models
{
    [Table("fabricante")]
    public class Fabricante
    {
        [Key]
        [Column("id_fabricante")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [ScaffoldColumn(false)]
        public int Id { get; set; }

        [Column("nome")]
        [StringLength(50)]
        public string Nome { get; set; }

        [Column("carro")]
        public List<Carro> carros { get; set; }
    }
}