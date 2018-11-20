using GestaoDoConecimento.Dados;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestaoDoConhecimento.Persistencia
{
    public class DBContexto : DbContext
    {
        public DbSet<Pessoa> Pessoas { get; set; }
        public DbSet<Problema> Problemas { get; set; }
        public DbSet<Atividade> Atividades { get; set; }
        public DbSet<Solucao> Solucoes { get; set; }
        public DbSet<Conhecimento> Conhecimentos { get; set; }

        public DBContexto() : base("GestDoConhecimento")
        {

        }
    }
}
