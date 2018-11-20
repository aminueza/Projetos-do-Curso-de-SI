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
    public class ConhecimentoController : Controller
    {
        private DBContexto db = new DBContexto();

        // GET: Conhecimento
        public ActionResult Index()
        {
            return View(db.Conhecimentos.ToList());
        }

        // GET: Conhecimento/Details/5
        public ActionResult Details(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Conhecimento conhecimento = db.Conhecimentos.Find(id);
            if (conhecimento == null)
            {
                return HttpNotFound();
            }
            return View(conhecimento);
        }

        // GET: Conhecimento/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Conhecimento/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id")] Conhecimento conhecimento)
        {
            if (ModelState.IsValid)
            {
                db.Conhecimentos.Add(conhecimento);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(conhecimento);
        }

        // GET: Conhecimento/Edit/5
        public ActionResult Edit(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Conhecimento conhecimento = db.Conhecimentos.Find(id);
            if (conhecimento == null)
            {
                return HttpNotFound();
            }
            return View(conhecimento);
        }

        // POST: Conhecimento/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id")] Conhecimento conhecimento)
        {
            if (ModelState.IsValid)
            {
                db.Entry(conhecimento).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(conhecimento);
        }

        // GET: Conhecimento/Delete/5
        public ActionResult Delete(long? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Conhecimento conhecimento = db.Conhecimentos.Find(id);
            if (conhecimento == null)
            {
                return HttpNotFound();
            }
            return View(conhecimento);
        }

        // POST: Conhecimento/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(long id)
        {
            Conhecimento conhecimento = db.Conhecimentos.Find(id);
            db.Conhecimentos.Remove(conhecimento);
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
