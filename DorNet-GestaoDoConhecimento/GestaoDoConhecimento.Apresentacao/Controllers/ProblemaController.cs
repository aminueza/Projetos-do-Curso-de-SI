using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using GestaoDoConecimento.Dados;
using GestaoDoConhecimento.Persistencia;

namespace GestaoDoConhecimento.Apresentacao.Controllers
{
    public class ProblemaController : Controller
    {
        private DBContexto db = new DBContexto();

        // GET: Problema
        public ActionResult Index()
        {
            var problemas = db.Problemas.Include(p => p.Atividade);
            return View(problemas.ToList());
        }

        // GET: Problema/Details/5
        public ActionResult Details(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Problema problema = db.Problemas.Find(id);
            if (problema == null)
            {
                return HttpNotFound();
            }
            return View(problema);
        }

        // GET: Problema/Create
        public ActionResult Create()
        {
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade");
            return View();
        }

        // POST: Problema/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,AtividadeId,NomeProblema,Descricao")] Problema problema)
        {
            if (ModelState.IsValid)
            {
                db.Problemas.Add(problema);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", problema.AtividadeId);
            return View(problema);
        }

        // GET: Problema/Edit/5
        public ActionResult Edit(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Problema problema = db.Problemas.Find(id);
            if (problema == null)
            {
                return HttpNotFound();
            }
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", problema.AtividadeId);
            return View(problema);
        }

        // POST: Problema/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,AtividadeId,NomeProblema,Descricao")] Problema problema)
        {
            if (ModelState.IsValid)
            {
                db.Entry(problema).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.AtividadeId = new SelectList(db.Atividades, "Id", "NomeAtividade", problema.AtividadeId);
            return View(problema);
        }

        // GET: Problema/Delete/5
        public ActionResult Delete(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Problema problema = db.Problemas.Find(id);
            if (problema == null)
            {
                return HttpNotFound();
            }
            return View(problema);
        }

        // POST: Problema/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Problema problema = db.Problemas.Find(id);
            db.Problemas.Remove(problema);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
