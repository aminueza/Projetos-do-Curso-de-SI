using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using System.Linq;

namespace Consultorio
{
    [TestClass]
    public class ClasseDeTestes
    {
        private Paciente paciente;
        private Especialidade especialidade;
        private Medico medico;
        private Consulta consulta;

        [TestMethod]
        public void InserirComBusca()
        {
            especialidade = new Especialidade();
            especialidade.NomeDaEspecialidade = "Psicologia";

            paciente = new Paciente();
            paciente.Nome = "Marianne";
            paciente.CartaoSus = 345;

            medico = new Medico();
            medico.Nome = "Jonas";
            medico.Crm = 321;
            medico.especialidade = especialidade;

            consulta = new Consulta();
            consulta.Descricao = "Paciente com queixa de dor na coluna";
            consulta.Data = new DateTime(2015, 11, 04);
            consulta.Hora = DateTime.Now.Add(new TimeSpan(14, 20, 20));
            consulta.Paciente = paciente;
            consulta.Medico = medico;

            using (var contexto = new ConsultorioDbContext())
            {
                contexto.Especialidades.Add(especialidade);
                contexto.Medicos.Add(medico);
                contexto.Pacientes.Add(paciente);
                contexto.Consultas.Add(consulta);
                contexto.SaveChanges();
            }

            using (var contexto = new ConsultorioDbContext())
            {
                Assert.AreEqual("Marianne", contexto.Pacientes.Find(1).Nome);
                Assert.AreEqual("Jonas", contexto.Medicos.Find(1).Nome);
                Assert.AreEqual("Psicologia", contexto.Especialidades.Find(1).NomeDaEspecialidade);
                Assert.AreEqual("Paciente com queixa de dor na coluna", contexto.Consultas.Find(1).Descricao);
            }

        }

        [TestMethod]
        public void AtualizarComBusca()
        {
            using (var contexto = new ConsultorioDbContext())
            {
                var p = contexto.Pacientes.Find(1); p.Nome = "Mateus";
                var m = contexto.Medicos.Find(1); m.Nome = "Lucas";
                var e = contexto.Especialidades.Find(1); e.NomeDaEspecialidade = "Ortopedista";
                var c = contexto.Consultas.Find(1); c.Descricao = "Dor de barriga";
                contexto.SaveChanges();
            }
            using (var contexto = new ConsultorioDbContext())
            {
                Assert.AreEqual("Mateus", contexto.Pacientes.Find(1).Nome);
                Assert.AreEqual("Lucas", contexto.Medicos.Find(1).Nome);
                Assert.AreEqual("Ortopedista", contexto.Especialidades.Find(1).NomeDaEspecialidade);
                Assert.AreEqual("Dor de barriga", contexto.Consultas.Find(1).Descricao);
            }
        }
        [TestMethod]
        public void ExcluirEListar()
        {
            using (var contexto = new ConsultorioDbContext())
            {
                contexto.Pacientes.Remove(contexto.Pacientes.Find(1));
                contexto.Medicos.Remove(contexto.Medicos.Find(1));
                contexto.Especialidades.Remove(contexto.Especialidades.Find(1));
                contexto.Consultas.Remove(contexto.Consultas.Find(1));
                contexto.SaveChanges();
            }
            using (var contexto = new ConsultorioDbContext())
            {
                var listaPacientes = from p in contexto.Pacientes select p;
                List<Paciente> pacientes = new List<Paciente>();
                foreach (var p in listaPacientes) { pacientes.Add(p); }

                var listaMedicos = from m in contexto.Medicos select m;
                List<Medico> medicos = new List<Medico>();
                foreach (var m in listaMedicos) { medicos.Add(m); }

                var listaEspeciades = from e in contexto.Especialidades select e;
                List<Especialidade> especialidades = new List<Especialidade>();
                foreach (var e in listaEspeciades) { especialidades.Add(e); }

                var listaConsultas = from c in contexto.Consultas select c;
                List<Consulta> consultas = new List<Consulta>();
                foreach (var c in listaConsultas) { consultas.Add(c); }


                Assert.IsTrue(pacientes.Count.Equals(0));
                Assert.IsTrue(medicos.Count.Equals(0));
                Assert.IsTrue(especialidades.Count.Equals(0));
                Assert.IsTrue(consultas.Count.Equals(0));
            }
        }
    }
}
