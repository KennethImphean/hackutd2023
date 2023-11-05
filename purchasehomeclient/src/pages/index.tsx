import Image from 'next/image';
import Head from 'next/head';
import Link from "next/link";
import Navbar from './components/navbar';

const Home = () => {
  return (
    <>
      <Head>
        <title>Home Pre-Approval Homepage</title>
        <meta name="description" content="Homepage"></meta>
      </Head>
      <h1 className="text-3xl font-bold">
        <Navbar/>
      </h1>
      <div className="mx-6 h-full">
          <h2 className="pt-24 pb-6 text-3xl font-bold text-slate-600 text-center">
            About This Project
          </h2>
          <div className="rounded-lg bg-slate-200 p-8 shadow-md">
            <p className="mt-2 space-y-4 text-lg text-slate-500">
              This project evaluates data from potential homebuyers and determines if they
              can be approved to buy a home. The tool allows the user to input an ID and the tool
              will present the data associated with the mentioned ID. It will then determine whether or not they 
              would be able to buy a home. The tool also allows users to type in their own data to determine if they
              would be elligible to buy a home themselves.
            </p>
          </div>
          <div className = "text-center pt-20 space-x-20">
          <Link href="/exampledata">
          <button
            className="mr-2 text-xl rounded-2xl bg-orange-500 px-16 py-10 font-bold text-white transition-colors hover:bg-orange-600"
          >
            Pre-Defined Data
          </button>
          </Link>
          <Link href="/userinputdata">
          <button
            type="submit"
            form="settings-form"
            className="mr-2 text-xl rounded-2xl bg-orange-500 px-12 py-10 font-bold text-white transition-colors hover:bg-orange-600"
          >
            Input Your Own Data
          </button>
          </Link>
          </div>
      </div>
    </>
  )
};
export default Home;